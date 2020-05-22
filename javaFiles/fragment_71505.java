package com.ggl.traffic.signal.thread;

import javax.swing.SwingUtilities;

import com.ggl.traffic.signal.model.TrafficSignalModel;
import com.ggl.traffic.signal.view.TrafficSignalLightPanel;
import com.ggl.traffic.signal.view.TrafficSignalPanel;

public class TrafficSignalCycle extends Thread {

    protected boolean isRunning;
    protected boolean isFinished;

    protected TrafficSignalPanel tsPanel;

    public TrafficSignalCycle(TrafficSignalPanel tsPanel) {
        this.tsPanel = tsPanel;
        this.isRunning = true;
        this.isFinished = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            signalLightOn(tsPanel.getGreenLight(), TrafficSignalModel.GREEN_LIGHT_TIME);
            signalLightOn(tsPanel.getYellowLight(), TrafficSignalModel.YELLOW_LIGHT_TIME);
            signalLightOn(tsPanel.getRedLight(), TrafficSignalModel.RED_LIGHT_TIME);
        }
        this.isFinished = true;
    }

    protected void signalLightOn(TrafficSignalLightPanel light, int seconds) {
        if (isRunning) {
            setLightOn(light, true);
        }

        for (int i = 0; i < 1000 && isRunning; i++) {
            try {
                Thread.sleep(1L * seconds);
            } catch (InterruptedException e) {
            }
        }
        setLightOn(light, false);
    }

    protected void setLightOn(final TrafficSignalLightPanel light,
            final boolean isLightOn) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                light.setLightOn(isLightOn);

            }       
        });
    }

    public void stopRunning() {
        this.isRunning = false;
        while (!isFinished) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
            }
        }
    }

}