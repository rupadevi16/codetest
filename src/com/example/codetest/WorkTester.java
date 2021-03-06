package com.example.codetest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //SyncQueueExample example = new SyncQueueExample();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread(" Thread number" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all Orders");

    }



}