package com.ggl.traffic.signal.view;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TrafficSignalFrame {

    protected ButtonPanel bPanel;

    protected JFrame frame;

    protected TrafficSignalPanel tsPanel;

    public TrafficSignalFrame() {
        createPartControl();
    }

    protected void createPartControl() {
        tsPanel = new TrafficSignalPanel();
        bPanel = new ButtonPanel();

        bPanel.setTrafficSignalPanel(tsPanel);

        frame = new JFrame();
        frame.setTitle("Traffic Signal");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });


        frame.setLayout(new FlowLayout());
        frame.add(bPanel.getPanel());
        frame.add(tsPanel.getPanel());
        frame.pack();
//      frame.setBounds(100, 100, 400, 200);
        frame.setVisible(true);
    }

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

    public JFrame getFrame() {
        return frame;
    }

}