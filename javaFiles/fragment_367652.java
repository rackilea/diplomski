package com.afklm.myactu.util;

public class FollowedThread implements Runnable {
    private volatile String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public void run() {
        setState("Step 1 running");
        try {
            Thread.sleep(1000);
            setState("Step 2 running");
            Thread.sleep(2000);
            setState("Step 3 running");
            Thread.sleep(3000);
            setState("Thread finished");
        } catch (InterruptedException e) {
            setState("Thread interrupted");
        }
    }
}