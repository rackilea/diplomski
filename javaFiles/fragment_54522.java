import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame {
    private Timer timer;
    private int sec, min, hrs;
    private JPanel panel;
    private JButton start;
    private JLabel label1;

    public Test() {
        panel = new JPanel();
        label1 = new JLabel("" + hrs + " : " + min + " : " + sec);
        timer = new Timer(1000);
        start = new ToggleButton("Start", "Stop");
        panel.add(label1, BorderLayout.NORTH);
        panel.add(start, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setSize(240, 360);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void tick() {
        sec++;
        if (sec >= 60) {
            min++;
            sec = sec - 60;
        }
        if (min >= 60) {
            hrs++;
            min = min - 60;
        }
        label1.setText("" + hrs + " : " + min + " : " + sec);
    }

    private class ToggleButton extends JButton {
        private boolean selected;
        private String otherText;

        public ToggleButton(String text, String otherText) {
            super(text);
            this.otherText = otherText;
            this.setSelected(true);
            this.fixListener();
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        private void fixListener() {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if (isSelected()) {
                        setSelected(false);
                        timer.start();
                    } else {
                        setSelected(true);
                        timer.pause();
                    }
                    String text = getText();
                    setText(otherText);
                    otherText = text;
                }
            });
        }
    }

    private class Timer extends Thread {
        private Thread thread;
        private boolean running;
        private boolean paused;
        private int ping;

        public Timer(int ping) {
            this.ping = ping;
            running = false;
            paused = true;
        }

        private void loop() {
            while (running) {
                if (!paused) {
                    tick();
                }
                delay(ping);
            }
        }

        private void delay(int mil) {
            try {
                Thread.sleep(mil);
            } catch (InterruptedException e) {
            }
        }

        public void start() {
            if (thread == null) {
                thread = new Thread(this);
                thread.start();
            } else {
                paused = false;
            }
        }

        public void pause() {
            paused = true;
        }

        @Override
        public void run() {
            running = true;
            paused = false;
            loop();
        }
    }
}