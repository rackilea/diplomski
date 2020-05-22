import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Textmovie extends JFrame {

    public static void main(String[] args) {
        new Textmovie();
    }

    public Textmovie() throws HeadlessException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jf = new JFrame("");
                jf.setUndecorated(true);
                jf.setBackground(new Color(0, 0, 0, 10));
                //jf.setOpacity(0.55f);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.add(new texscroll());
                jf.pack();
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });
    }

    public static class texscroll extends JPanel {

        private int x = 510, y = 25;

        private String string = "stackoverflow stackoverflow stackoverflow stackoverflow";

        public texscroll() {
            Font font = new Font("Arial", Font.BOLD + Font.PLAIN, 15);
            setFont(font); 
            setForeground(Color.BLACK);

            setOpaque(false);
            Timer timer = new Timer(14, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    x -= 1;

                    if (x == -10 * string.length()) {
                        x = 510;
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(720, 480);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            Graphics2D g2 = (Graphics2D) g;

            g2.drawString(string, x, y);
        }
    }
}