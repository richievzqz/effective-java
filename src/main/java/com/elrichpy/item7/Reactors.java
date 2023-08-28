package com.elrichpy.item7;

import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Stream;

public class Reactors {
    static final List<String> ITEMS = List.of("Chips",
            "Ice Cream",
            "Hot Dog",
            "Pizza",
            "Soda",
            "Fries");
    public static class Orders {
        int orderNumber;
        String type;
        Map<String, Integer> items;
        static int orderNumberInc;
        Orders(String type) {
            orderNumber = orderNumberInc++;
            this.type = type;
            this.items = new HashMap<>();
        }
        public void addItem(String item, Integer quantity) {
            items.put(item, quantity);
        }
    }
    public static void main(String[] args) {
        Flux<Orders> ordersFlux = createOrders();
    }

    static Flux<Orders> createOrders() {
        return Flux.create(fluxSink -> {

        });
        Random random = new Random();
        int numOfOrders = random.nextInt(10);
        for (int i = 0; i < numOfOrders; i++) {
            ITEMS.forEach(item -> {
                if (random.nextBoolean()) {

                }
            });
        }

    }
}
