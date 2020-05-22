import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ChangeColor {

    public ChangeColor() {
        JFrame frame = new JFrame();
        frame.add(new ColorPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class ColorPanel extends JPanel {

        private static final int DELAY = 30;
        private static final int INCREMENT = 5;
        private Color currentColor = Color.BLUE;
        boolean isBlue = true;
        boolean isGreen = false;
        private int r,g,b;

        private Timer timer = null;
        private JButton greenButton = null;
        private JButton blueButton = null;

        public ColorPanel() {
            r = 0; g = 0; b = 255;

            greenButton = createGreenButton();
            blueButton = createBlueButton();

            timer = new Timer(DELAY, new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (isBlue) {
                        if (b == 0) {
                            stopTimer();
                            enableButtons();
                        } else {
                            blueToGreen();
                            setColor(new Color(r, b, g));
                        }
                    } 

                    if (isGreen) {
                        if (g == 0) {
                            stopTimer();
                            enableButtons();
                        } else {
                            greenToBlue();
                            setColor(new Color(r, b, g));
                        }
                    }

                    repaint();
                }
            });

            add(blueButton);
            add(greenButton);
        }

        public JButton createBlueButton() {
            JButton button = new JButton("BLUE");
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if (currentColor != new Color(0, 255, 0)) {
                        System.out.println("turn blue");
                        isBlue = true;
                        isGreen = false;
                        diableButtons();
                        startTimer();   
                    }
                }
            });
            return button;
        }

        public void diableButtons() {
            blueButton.setEnabled(false);
            greenButton.setEnabled(false);
        }

        public void enableButtons() {
            blueButton.setEnabled(true);
            greenButton.setEnabled(true);
        }

        public JButton createGreenButton() {
            JButton button = new JButton("GREEN");
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if (currentColor != new Color(0, 0, 255)) {
                        System.out.println("turn green");
                        isGreen = true;
                        isBlue = false;
                        diableButtons();
                        startTimer();

                    }
                }
            });
            return button;
        }

        private void blueToGreen() {
            b -= INCREMENT;
            g += INCREMENT;
        }

        private void greenToBlue() {
            g -= INCREMENT;
            b += INCREMENT;
        }



        public void setColor(Color color) {
            this.currentColor = color;
        }

        public void startTimer() {
            timer.start();
        }

        public void stopTimer() {
            timer.stop();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(currentColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new ChangeColor();
            }
        });

    }
}