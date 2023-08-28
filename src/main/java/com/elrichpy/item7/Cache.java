package com.elrichpy.item7;

import java.time.Instant;
import java.util.Date;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Cache {
    static class Command implements Runnable {
        public String taskName;
        public Command(String taskName) {
            this.taskName = taskName;
        }
        @Override
        public void run() {
            Date date = Date.from(Instant.now());
            System.out.println("Task: ".concat(taskName).concat(" - Date = ").concat(date.toString()));
        }
    }
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);

        Runnable task1 = new Command("Task1");
        Runnable task2 = new Command("Task2");

        scheduledThreadPoolExecutor.schedule(task1, 1, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.schedule(task2, 5, TimeUnit.SECONDS);

        scheduledThreadPoolExecutor.shutdown();
    }
}
