package com.coralblocks.coralqueue.sample.demux;

import com.coralblocks.coralqueue.demux.CASAtomicDemux;
import com.coralblocks.coralqueue.demux.Demux;

public class Sample {

    private static final int NUMBER_OF_CONSUMERS = 4;

    public static void main(String[] args) throws InterruptedException {

        final Demux<StringBuilder> queue = new CASAtomicDemux<StringBuilder>(1024, StringBuilder.class, NUMBER_OF_CONSUMERS);

        Thread[] consumers = new Thread[NUMBER_OF_CONSUMERS];

        for(int i = 0; i < consumers.length; i++) {

            final int index = i;

            consumers[i] = new Thread() {

                @Override
                public void run() {

                    boolean running = true;

                    while(running) {
                        long avail;
                        while((avail = queue.availableToPoll(index)) == 0); // busy spin
                        for(int i = 0; i < avail; i++) {
                            StringBuilder sb = queue.poll(index);

                            if (sb == null) break; // mandatory for demuxes!

                            if (sb.length() == 0) {
                                running = false;
                                break; // exit immediately...
                            } else {
                                System.out.println(sb.toString());
                            }
                        }
                        queue.donePolling(index);
                    }
                }
            };

            consumers[i].start();
        }

        StringBuilder sb;

        for(int i = 0; i < 10; i++) {
            while((sb = queue.nextToDispatch()) == null); // busy spin
            sb.setLength(0);
            sb.append("message ").append(i);
            queue.flush();
        }

        // send a message to stop consumers...
        for(int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
            // because the consumer exit immediately on this message, each
            // consumer will get one of these messages and exit...
            while((sb = queue.nextToDispatch()) == null); // busy spin
            sb.setLength(0);
        }
        queue.flush(); // sent batch

        for(int i = 0; i < consumers.length; i++) consumers[i].join();
    }
}