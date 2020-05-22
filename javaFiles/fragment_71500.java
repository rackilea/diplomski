package com.ggl.traffic.signal;

import javax.swing.SwingUtilities;

import com.ggl.traffic.signal.view.TrafficSignalFrame;

public class TrafficSignal implements Runnable {

    @Override
    public void run() {
        new TrafficSignalFrame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TrafficSignal());
    }

}