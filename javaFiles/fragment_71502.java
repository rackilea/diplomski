package com.ggl.traffic.signal.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TrafficSignalLightPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    protected boolean lightOn;

    protected Color lightColor;
    protected Color darkColor;

    public TrafficSignalLightPanel(Color lightColor) {
        this.lightColor = lightColor;
        this.darkColor = Color.WHITE;
        this.lightOn = false;
    }

    public void setLightOn(boolean lightOn) {
        this.lightOn = lightOn;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (lightOn) {
            g.setColor(lightColor);
        } else {
            g.setColor(darkColor);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}