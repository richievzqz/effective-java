package com.elrichpy.item7;

import reactor.core.publisher.Mono;

import java.util.concurrent.*;

public class Futures {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        System.out.println(Thread.currentThread());
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("First task");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread());

            return "Done with first completable future";
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Second task");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread());

            return "Done with second completable future";
        });

        completableFuture1.thenApplyAsync(response -> {
            System.out.println("Running Future 1 in: ".concat(Thread.currentThread().toString()));
            return response;
        }).whenCompleteAsync((response, error) -> {
            System.out.println(response);
        });

        completableFuture2.whenCompleteAsync((response, error) -> System.out.println(response));

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(completableFuture1, completableFuture2);
        combinedFuture.get(20, TimeUnit.SECONDS);
    }

}
