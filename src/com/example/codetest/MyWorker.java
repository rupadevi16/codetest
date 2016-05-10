package com.example.codetest;

import java.util.concurrent.BlockingQueue;

public class MyWorker extends Thread {
    private final BlockingQueue<String> queue;
    public MyWorker(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while ( true ) {

                String s = queue.take();
                doWork(s);
            }
        }
        catch ( InterruptedException ie ) {
            // just terminate
        }
    }

    public void doWork(String s){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The test ends when all Orders are FULFILLED." + s);
    }
}
