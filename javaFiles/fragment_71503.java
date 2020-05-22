package com.ggl.traffic.signal.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.ggl.traffic.signal.model.TrafficSignalModel;

public class TrafficSignalPanel {

    protected JPanel panel;

    protected TrafficSignalLightPanel redLight;
    protected TrafficSignalLightPanel yellowLight;
    protected TrafficSignalLightPanel greenLight;

    public TrafficSignalPanel() {
        createPartControl();
    }

    protected void createPartControl() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);

        redLight = new TrafficSignalLightPanel(Color.RED);
        redLight.setBorder(border);
        redLight.setPreferredSize(TrafficSignalModel.LIGHT_SIZE);

        yellowLight = new TrafficSignalLightPanel(Color.YELLOW);
        yellowLight.setBorder(border);
        yellowLight.setPreferredSize(TrafficSignalModel.LIGHT_SIZE);

        greenLight = new TrafficSignalLightPanel(Color.GREEN);
        greenLight.setBorder(border);
        greenLight.setPreferredSize(TrafficSignalModel.LIGHT_SIZE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(
                new Dimension(TrafficSignalModel.LIGHT_SIZE.width + 10, 
                        TrafficSignalModel.LIGHT_SIZE.height * 3 + 25));

        panel.add(redLight);
        panel.add(yellowLight);
        panel.add(greenLight);
    }

    public JPanel getPanel() {
        return panel;
    }

    public TrafficSignalLightPanel getRedLight() {
        return redLight;
    }

    public TrafficSignalLightPanel getYellowLight() {
        return yellowLight;
    }

    public TrafficSignalLightPanel getGreenLight() {
        return greenLight;
    }

}