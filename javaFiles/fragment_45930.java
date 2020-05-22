package com.example.swing;

import javax.swing.*;
import java.awt.*;

public class DemoFontMetrics {

    public static void main(String[] args){
        JFrame frame = new JFrame();
        DecoratedLabel label = new DecoratedLabel("hello world !",new int[]{2,4}, new int[]{6,9});
        JPanel textContainer = new JPanel(new FlowLayout());
        textContainer.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        textContainer.add(label);
        frame.getContentPane().add(textContainer);
        frame.pack();
        frame.setVisible(true);
    }

    private static class DecoratedLabel extends JLabel{

        int startBlue;
        int endBlue;
        int startRed;
        int endRed;

        private DecoratedLabel(String text, int[] blueRange, int[] redRange) {
            super(text);
            startBlue = blueRange[0];
            endBlue = blueRange[1];
            startRed = redRange[0];
            endRed = redRange[1];
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);   //draw text

            //set line with : 3
            Stroke stroke = new BasicStroke(3f);
            ((Graphics2D)g).setStroke(stroke);

            FontMetrics fm = g.getFontMetrics();
            int h = fm.getHeight();

            //compute blue line coordonate
            fm.stringWidth(getText().substring(0,startBlue));
            int x1 = fm.stringWidth(getText().substring(0, startBlue));
            int x2 = fm.stringWidth(getText().substring(0, endBlue));
            g.setColor(Color.BLUE);
            g.drawLine(x1,0,x2,0);// draw blue line

            //compute red line coordonates
            int x3 = fm.stringWidth(getText().substring(0,startRed));
            int x4 = fm.stringWidth(getText().substring(0, endRed));
            g.setColor(Color.RED);
            g.drawLine(x3,h-1,x4,h-1); // draw redline

        }
    }
}