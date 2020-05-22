import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Show_starter {

    private Timer tmr;

    int x, y;
    JFrame window = new JFrame("Graphic_show");
    Graphic_panel jp = new Graphic_panel();

    public static void main(String[] args) {

        Show_starter start = new Show_starter();
        start.go();

    }

    private void go() {

        window.getContentPane().add(BorderLayout.CENTER, jp);
        window.setSize(600, 800);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tmr = new Timer(10, new ActionListener() { // time gap in millisecond

            @Override
            public void actionPerformed(ActionEvent ae) {

                jp.increse();
                jp.repaint();
            }
        });
        tmr.start();

    }

    class Graphic_panel extends JPanel {

        public void increse() {
            x++;
            y++;
            if (x > 100) { // stop animation at x>100
                tmr.stop();
            }
        }

        public void paintComponent(Graphics g) {

            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);

        }

    }
}