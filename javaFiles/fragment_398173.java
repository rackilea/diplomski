import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class Snake2 extends JFrame {

    String direction = "right";

    //String duration = 

    /* Sprite: snake head co-ordinates */
    int x = 400;
    int y = 450;
    int width = 10;
    int height = 10;

    /* Sprite: snake body */
    int length = 0;
    ArrayList<Integer> bodyX = new ArrayList<Integer>();
    ArrayList<Integer> bodyY = new ArrayList<Integer>();

    /* Score */
    int point = 0;

    /* Sprite: mouse co-ordinates */
    Random rand = new Random();
    int addx = (rand.nextInt(10)) * 10;
    int addy = (rand.nextInt(10)) * 10;
    int mx = ((rand.nextInt(5) + 1) * 100) + addx;
    int my = ((rand.nextInt(6) + 2) * 100) + addy;

    DrawPanel drawPanel = new DrawPanel();
    Timer timer;
    public Snake2() {

        addMouseListener(new MouseListener());

        timer = new Timer(50, new TimerListener());     ////////////// <<<<<<<<<<<<<<<<<< TIMER
        timer.start();
        System.out.print(mx + " " + my);

        /* move snake up */
        Action upAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                direction = "up";                       ////////////// <<<<<<<<<<<<<<<<<< direction only change
            }
        };

        /* move snake down */
        Action downAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                direction = "down";
            }
        };

        /* move snake left */
        Action leftAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                direction = "left";
            }
        };

        /* move snake right */
        Action rightAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                direction = "right";
            }
        };

        InputMap inputMap = drawPanel
                .getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = drawPanel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        actionMap.put("rightAction", rightAction);

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        actionMap.put("leftAction", leftAction);

        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        actionMap.put("downAction", downAction);

        inputMap.put(KeyStroke.getKeyStroke("UP"), "upAction");
        actionMap.put("upAction", upAction);

        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }// Snake2()

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {                /////////////////// <<<<<<<<<<<<<< All logic here
            if ("right".equals(direction)) { 
                x += 10;

                if (x >= mx && x <= mx + 9 && y >= my && y <= my + 9) {
                    addx = (rand.nextInt(10)) * 10;
                    addy = (rand.nextInt(10)) * 10;
                    mx = ((rand.nextInt(5) + 1) * 100) + addx;
                    my = ((rand.nextInt(6) + 1) * 100) + addy;
                    point += 100;
                    length++;
                    bodyX.add(0, x);
                }

                if (x > 699) {
                    new GameOver();
                    dispose();
                }
            } else if ("left".equals(direction)) {
                x -= 10;

                if (x >= mx && x <= mx + 9 && y >= my && y <= my + 9) {
                    addx = (rand.nextInt(10)) * 10;
                    addy = (rand.nextInt(10)) * 10;
                    mx = ((rand.nextInt(5) + 1) * 100) + addx;
                    my = ((rand.nextInt(6) + 1) * 100) + addy;
                    point += 100;
                    length++;
                    bodyX.add(0, x);
                }

                if (x < 99) {
                    new GameOver();
                    dispose();
                }
            } else if ("up".equals(direction)) {
                y -= 10;

                if (y >= my && y <= my + 9 && x >= mx && x <= mx + 9) {
                    addx = (rand.nextInt(10)) * 10;
                    addy = (rand.nextInt(10)) * 10;
                    mx = ((rand.nextInt(5) + 1) * 100) + addx;
                    my = ((rand.nextInt(6) + 1) * 100) + addy;
                    point += 100;
                    length++;
                    bodyY.add(0, y);
                }

                if (y < 99) {
                    new GameOver();
                    dispose();
                }


            } else if ("down".equals(direction)) {
                y += 10;

                if (y >= my && y <= my + 9 && x >= mx && x <= mx + 9) {
                    addx = (rand.nextInt(10)) * 10;
                    addy = (rand.nextInt(10)) * 10;
                    mx = ((rand.nextInt(5) + 1) * 100) + addx;
                    my = ((rand.nextInt(6) + 1) * 100) + addy;
                    point += 100;
                    length++;
                    bodyY.add(0, y);
                }

                if (y > 799) {
                    new GameOver();
                    dispose();
                }
            } 
            drawPanel.repaint();
        }
    }

    private class GameOver extends JFrame implements ActionListener {
        JLabel answer = new JLabel("");
        JPanel pane = new JPanel(); // create pane object
        JButton pressme = new JButton("Quit");
        JButton replay = new JButton("Replay?");

        GameOver() // the constructor
        {

            super("Game Over");
            timer.stop();                                           ////////////////////// <<<<<<<<<< Stop TIMER
            setBounds(100, 100, 300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container con = this.getContentPane(); // inherit main frame
            con.add(pane);
            pressme.setMnemonic('Q'); // associate hotkey
            pressme.addActionListener(this); // register button listener
            replay.addActionListener(this);
            pane.add(answer);
            pane.add(pressme);
            pane.add(replay);
            pressme.requestFocus();
            answer.setText("You Lose");
            setVisible(true); // make frame visible
        }// GameOver()

        // here is the basic event handler
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source == pressme)
                System.exit(0);
            if (source == replay) {
                dispose();
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Snake2();
                    }
                });
            }
        }// actionPreformed

    }// GameOver

    private class DrawPanel extends JPanel {

        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Font ith = new Font("Ithornît", Font.BOLD, 78);

            /* Background: Snake */
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.gray);
            g.fillRect(100, 100, 600, 700);
            g.setColor(Color.white);
            g.drawRect(99, 99, 601, 701);

            g.drawString("Quit", 102, 86);
            g.drawRect(100, 70, 30, 20);
            g.drawString("Score: ", 602, 86);

            g.setFont(ith);
            g.drawString("SNAKE", 350, 60);

            /* Sprite: Mouse */
            g.setColor(Color.black);
            g.fillRect(mx, my, width, height);
            // System.out.print(mx + " " + my);

            /* Sprite: Snake Body */
            if (length != 0) {
                for (int i = 0; i >= length; i++) {
                    g.setColor(Color.darkGray);
                    g.fillRect(bodyX.get(i), bodyY.get(i), width, height);
                }
            }

            /* Sprite: Snake head */
            g.setColor(Color.white);
            g.fillRect(x, y, width, height);

        }// Paint Component

        public Dimension getPreferredSize() {
            return new Dimension(800, 850);
        }// Dimension

    }// DrawPanel

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Snake2();
            }
        });
    }// main

}// Snake Class

/* Tracks where mouse is clicked */
class MouseListener extends MouseAdapter {

    public void mouseReleased(MouseEvent me) {
        if (me.getX() >= 101 && me.getX() <= 131 && me.getY() >= 94
                && me.getY() <= 115) {
            System.exit(0);
        }

        String str = "Mouse Released at " + me.getX() + "," + me.getY();
        System.out.println(str);
    }
}// MouseAdapter