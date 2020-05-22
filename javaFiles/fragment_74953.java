import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Countdown1 extends JApplet {

    @Override
    public void init() {
        add(new CounterPane());
    }

    public class CounterPane extends JPanel {

        String input = JOptionPane.showInputDialog("Enter seconds: ");

        int counter = Integer.parseInt(input);

        public CounterPane() {

            Timer timer;

            timer = new Timer(1000, new ActionListener() /* counting down time inputted */ {
                public void actionPerformed(ActionEvent evt) {
                    System.out.println(counter);
                    if (counter > 0) {

                        counter--;

                        setBackground(Color.orange);
                        setForeground(Color.magenta);

                        if (counter <= 0) {
                            setBackground(Color.cyan);
                        }

                        repaint();
                    }
                }
            });

            timer.start();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(new Font("Times New Roman", Font.BOLD, 35));
            g.setColor(getForeground());
            g.drawString("Seconds: " + String.valueOf(counter), 260, 210);
        }

    }
}