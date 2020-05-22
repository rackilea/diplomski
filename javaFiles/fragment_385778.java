import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Balls extends JApplet {

    private static final long serialVersionUID = 1L;
    JPanel btnPanel = new JPanel();
    static boolean flag1 = true;
    static boolean flag2 = true;
    static boolean flag3 = false;
    static int h;
    static int temp = 10;
    JButton start;
    JButton stop;
    private Timer timer;

    public void init() {
            SwingUtilities.invokeLater(

            new Runnable() {
                public void run() {
                    makeGUI();
                }

            });
    }

    private void makeGUI() {
        timer = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                repaint();
            }
        });
        start = new JButton("start");
        stop = new JButton("stop");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                timer.start();
            }
        });
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                timer.stop();
            }
        });
        btnPanel.add(start);
        btnPanel.add(stop);
        add(new MyPanel(), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.NORTH);
    }

    class MyPanel extends JPanel{

        public void paintComponent(Graphics g) {
             super.paintComponent(g);
            int h = Integer.parseInt(getParameter("height"));
            if (flag1) {
                g.setColor(Color.RED);
                g.fillOval(10, h, 50, 50);
                g.setColor(Color.YELLOW);
                g.fillOval(50, h, 20, 20);
                g.setColor(Color.CYAN);
                g.fillOval(70, h, 80, 30);
                g.setColor(Color.BLUE);
                g.fillOval(120, h, 50, 60);
                g.setColor(Color.GRAY);
                g.fillOval(160, h, 70, 50);
                g.setColor(Color.GREEN);
                g.fillOval(200, h, 80, 80);
                g.setColor(Color.MAGENTA);
                g.fillOval(260, h, 80, 30);
                g.setColor(Color.DARK_GRAY);
                g.fillOval(320, h, 60, 40);
                g.setColor(Color.pink);
                g.fillOval(370, h, 65, 45);
                flag1 = false;
            } else {
                g.setColor(Color.RED);
                g.fillOval(10, h - temp, 50, 50);
                g.setColor(Color.YELLOW);
                g.fillOval(50, h - temp, 20, 20);
                g.setColor(Color.CYAN);
                g.fillOval(70, h - temp, 80, 30);
                g.setColor(Color.BLUE);
                g.fillOval(120, 355, 50, 60);
                g.setColor(Color.GRAY);
                g.fillOval(160, h - temp, 70, 50);
                g.setColor(Color.GREEN);
                g.fillOval(200, h - temp, 80, 80);
                g.setColor(Color.MAGENTA);
                g.fillOval(260, h - temp, 80, 30);
                g.setColor(Color.DARK_GRAY);
                g.fillOval(320, h - temp, 60, 40);
                g.setColor(Color.pink);
                g.fillOval(370, h - temp, 65, 45);
                if (flag2 && temp <= 400) {
                    temp += 10;
                    if (temp == 400) {
                        flag2 = false;
                    }
                } else if (!flag2) {
                    temp -= 10;
                    if (temp == 10) {
                        flag2 = true;
                    }
                } else {

                }
            }
        }
    }
}