package com.example.codetest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SyncQueueExample {
    // Ö
    public SyncQueueExample() {
        try {
            int workItem = 0;
            // Create a synchronous queue
            int MAX_Q_SIZE = 5;
            BlockingQueue<String> queue = new ArrayBlockingQueue<String>(MAX_Q_SIZE);

            int POOL_SIZE = 10;
            // for ( int i = 0; i < POOL_SIZE; i++ ) {
            MyWorker worker = new MyWorker(queue);
            worker.start();
            //}

            // Start sending to the queue
            while ( workItem <10 ) {
                System.out.println("\nPlacing order on queue");
                String work = "Order:" + (++workItem);
                queue.put(work);
            }




        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}