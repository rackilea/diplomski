package com.example.app;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;


public class ConnectionWorker extends Thread {

    // Reference to service's handler.
    protected Handler handler;

    public ConnectionWorker(Handler handler) {
        super(ConnectionWorker.class.getName());

        // Saving injected reference.
        this.handler = handler;
    }

    @Override
    public void run() {

        super.run();

        Log.d(this.getClass().getName(), "Thread started");

        // Doing the work indefinitely.
        while (true) {

            if (this.isInterrupted()) {
                // Terminating this method when thread is interrupted.
                return;
            }

            Log.d(this.getClass().getName(), "Doing some work for 3 seconds...");

            // Sending a message back to the service via handler.
            Message message = this.handler.obtainMessage();
            message.obj = "Waiting for 3 seconds";
            this.handler.sendMessage(message);

            SystemClock.sleep(3 * 1000);
        }
    }
}