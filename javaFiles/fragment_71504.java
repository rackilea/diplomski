package com.ggl.traffic.signal.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ggl.traffic.signal.thread.TrafficSignalCycle;

public class ButtonPanel {

    protected JButton startButton;
    protected JButton stopButton;

    protected JPanel panel;

    protected TrafficSignalCycle thread;

    protected TrafficSignalPanel tsPanel;

    public ButtonPanel() {
        this.thread = null;
        createPartControl();
    }

    protected void createPartControl() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (thread != null) {
                    thread.stopRunning();
                }
                tsPanel.getRedLight().setLightOn(false);
                tsPanel.getYellowLight().setLightOn(false);
                tsPanel.getGreenLight().setLightOn(false);
                thread = new TrafficSignalCycle(tsPanel);
                thread.start();
            }
        });

        panel.add(startButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (thread != null) {
                    thread.stopRunning();
                    thread = null;
                }
                tsPanel.getRedLight().setLightOn(true);
                tsPanel.getYellowLight().setLightOn(false);
                tsPanel.getGreenLight().setLightOn(false);
            }
        });

        panel.add(stopButton);

        setButtonSizes(startButton, stopButton);
    }

    protected void setButtonSizes(JButton ... buttons) {
        Dimension preferredSize = new Dimension();
        for (JButton button : buttons) {
            Dimension d = button.getPreferredSize();
            preferredSize = setLarger(preferredSize, d);
        }
        for (JButton button : buttons) {
            button.setPreferredSize(preferredSize);
        }
    }

    protected Dimension setLarger(Dimension a, Dimension b) {
        Dimension d = new Dimension();
        d.height = Math.max(a.height, b.height);
        d.width = Math.max(a.width, b.width);
        return d;
    }

    public void setTrafficSignalPanel(TrafficSignalPanel tsPanel) {
        this.tsPanel = tsPanel;
    }

    public JPanel getPanel() {
        return panel;
    }

}