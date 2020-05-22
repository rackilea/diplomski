package net.eonz.stackoverflow.spiral;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, MouseListener {
    private static final long serialVersionUID = 1L;
    public static final String NAME = "untitled";
    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;
    public static final int SCALE = 1;

    private boolean running = false;

    public void start() {
        running = true;
        new Thread(this).start();
        this.addMouseListener(this);
    }

    public void stop() {
        running = false;
    }

    public void run() {
        long last = System.currentTimeMillis();

        while (running) {
            long now = System.currentTimeMillis();
            double dt = (now - last) / 1000.0;
            last = now;
            update(dt);
            render();
        }
    }

    double t = 0;

    public void update(double dt) {
        t += dt / 16;
        if (t > 1)
            t = 1;
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        /* SPIRAL MATH IS HERE */

        double startingRadius = this.getHeight() * 0.40;
        double rotations = 10;

        double x = getArmX(startingRadius * (1 - t), t * rotations * Math.PI
                * 2);
        double y = getArmY(startingRadius * (1 - t), t * rotations * Math.PI
                * 2);

        g.setColor(Color.black);
        g.fillRect((int) (x - 8) + this.getWidth() / 2,
                (int) (y - 8) + this.getHeight() / 2, 16, 16);

        /* END SPIRAL MATH */

        g.dispose();
        bs.show();
    }

    public static double getArmX(double length, double angle) {
        return Math.cos(angle) * length;
    }

    public static double getArmY(double length, double angle) {
        return Math.sin(angle) * length;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.t = 0;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        game.start();
    }

}