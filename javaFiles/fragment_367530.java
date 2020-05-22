package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Test extends JFrame {

    private static Test frame;
    private static double t;
    private static int x;
    private static int y;
    private static TextArea test;

    public static void main(String[] args) {
        frame = new Test();
        frame.setVisible(true);
        // set layout to null so that you can freely position your components
        // without them "filling up the whole screen"
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        // game loop
        new Timer(10, (e) -> {
            t += 10.0 / 1000;
            x = (int) (100 + 50 * Math.sin(t));
            y = (int) (100 + 50 * Math.cos(t));
            // calling repaint will cause Test.paint() to be called first,
            // then Test's children will be painted (= the TextArea)
            frame.repaint();
        }).start();

        // initialize the textarea only once
        test = new TextArea();
        test.setEditable(true);
        test.setBounds(new Rectangle(100, 100, 100, 100));
        test.setText("hi");
        frame.add(test);
    }

    @Override
    public void paint(Graphics g) {
        // put only painting logic in your paint/render.
        // don't set the bounds of components here, 
        // as this will trigger a repaint.
        g.setColor(Color.black);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.yellow);
        g.fillOval(x, y, 20, 20);
    }
}