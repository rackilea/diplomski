import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Mcve3 extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 640;
    private static final int TIMER_DELAY = 50;

    private int spriteX = 400;
    private int spriteY = 320;
    private SpriteDirection spriteDirection = SpriteDirection.RIGHT;
    private MySprite sprite = null;
    private Timer timer = null;

    public Mcve3() {
        try {
            sprite = new MySprite(spriteDirection, spriteX, spriteY);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        setBackground(Color.WHITE);

        setKeyBindings(SpriteDirection.LEFT, KeyEvent.VK_LEFT);
        setKeyBindings(SpriteDirection.RIGHT, KeyEvent.VK_RIGHT);
        setKeyBindings(SpriteDirection.FORWARD, KeyEvent.VK_DOWN);
        setKeyBindings(SpriteDirection.AWAY, KeyEvent.VK_UP);

        timer = new Timer(TIMER_DELAY, new TimerListener());
        timer.start();
    }

    private void setKeyBindings(SpriteDirection dir, int keyCode) {
        int condition = WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = getInputMap(condition);
        ActionMap actionMap = getActionMap();

        KeyStroke keyPressed = KeyStroke.getKeyStroke(keyCode, 0, false);
        KeyStroke keyReleased = KeyStroke.getKeyStroke(keyCode, 0, true);

        inputMap.put(keyPressed, keyPressed.toString());
        inputMap.put(keyReleased, keyReleased.toString());

        actionMap.put(keyPressed.toString(), new MoveAction(dir, false));
        actionMap.put(keyReleased.toString(), new MoveAction(dir, true));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite.draw(g);
    }

    private class MoveAction extends AbstractAction {
        private SpriteDirection dir;
        private boolean released;

        public MoveAction(SpriteDirection dir, boolean released) {
            this.dir = dir;
            this.released = released;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (released) {
                sprite.setMoving(false);
            } else {
                sprite.setMoving(true);
                sprite.setDirection(dir);
            }
        }
    }

    private class TimerListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                if (sprite.isMoving()) {
                    sprite.tick();
                }
                repaint();
            }
    }

    private static void createAndShowGui() {
        Mcve3 mainPanel = new Mcve3();

        JFrame frame = new JFrame("MCVE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}