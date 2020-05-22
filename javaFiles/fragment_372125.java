package com.ggl.testing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 506794466435048661L;

    private double currScale;

    private int choice;

    private BufferedImage img;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(choice);
        if (choice == 1) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            System.out.println("\nImgWidth: " + img.getWidth()
                    + "\nFrameWidth: " + getWidth() + "\nImgHeight: "
                    + img.getHeight() + "\nFrameHeight: " + getHeight());
        } else if (choice == 2) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            int w = getWidth();
            int h = getHeight();
            int imageWidth = img.getWidth();
            int imageHeight = img.getHeight();
            double x = (w - currScale * imageWidth) / 2;
            double y = (h - currScale * imageHeight) / 2;
            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            System.out.println("Pass");
            at.scale(currScale, currScale);
            System.out.println("Pass");
            g2.drawRenderedImage(img, at);
            System.out.println("Pass");
        }
    }

    public double getCurrScale() {
        return currScale;
    }

    public void setCurrScale(double currScale) {
        this.currScale = currScale;
        repaint();
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

}