package com.example.app;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;


public class ConnectionService extends Service {

    protected ConnectionWorker thread;

    static class LocalHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.d(this.getClass().getName(), "Message received: " + (String) msg.obj);
        }
    }
    protected Handler handler;


    @Override
    public void onCreate() {

        super.onCreate();

        // Instantiating overloaded handler.
        this.handler = new LocalHandler();

        // Creating a connection worker thread instance.
        // Not starting it yet.
        // Injecting our handler.
        this.thread = new ConnectionWorker(this.handler);

        Log.d(this.getClass().getName(), "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(this.getClass().getName(), "Trying to start the service");

        // Checking if worker thread is already running.
        if (!this.thread.isAlive()) {

            Log.d(this.getClass().getName(), "Starting working thread");

            // Starting the worker thread.
            this.thread.start();

            Log.d(this.getClass().getName(), "Service started");
        }

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {

        Log.d(this.getClass().getName(), "Stopping thread");

        // Stopping the thread.
        this.thread.interrupt();

        Log.d(this.getClass().getName(), "Stopping service");

        super.onDestroy();

        Log.d(this.getClass().getName(), "Service destroyed");
    }
}