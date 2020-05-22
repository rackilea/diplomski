package test;

import java.awt.Color;
import java.awt.Robot;
import java.awt.AWTException;

public class main {

    static final Color RED_COLOR = new Color(255, 0, 0);

    private static boolean colorsAreClose(Color color1, Color color2, int threshold) {
        int r = (int) color1.getRed() - color2.getRed(), g = (int) color1.getGreen() - color2.getGreen(),
                b = (int) color1.getBlue() - color2.getBlue();
        return (r * r + g * g + b * b) <= threshold * threshold;
    }

    public static void main(String[] args) {
        Color pixelColor = null;
        try {
            Robot robot = new Robot();
            pixelColor = robot.getPixelColor(500, 500);
            System.out.println(String.format("Red %d, Green %d, Blue %d", pixelColor.getRed(), pixelColor.getGreen(),
                    pixelColor.getBlue()));

        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }

        boolean isRedPixel = colorsAreClose(pixelColor, RED_COLOR, 50);
        System.out.println(isRedPixel ? "Pixel is red" : "Pixel is not red");
    }

}