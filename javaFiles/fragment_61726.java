import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Game04 extends JFrame {

    static Random random = new Random();

    static int max       = 370;
    static int min       = 0;

    static int x         = min + random.nextInt((max - min) + 1);
    static int y         = min + random.nextInt((max - min) + 1);

    static int num       = min + random.nextInt((max - min) + 1);
    static int xValues[] = {num,num,num,num,num,num,num,num,num};
    static int yValues[] = {num,num,num,num,num,num,num,num,num};

    static int xa[]      = {1,-1,1,-1,1,-1,1,-1,1};
    static int ya[]      = {1,-1,1,-1,1,-1,1,-1,1};

    Game04(){

        super("Mini Tennis");

        Game04Panel game  = new Game04Panel();
        setLayout(new BorderLayout());
        add(game, BorderLayout.CENTER);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        for(int i = 0; i < 9; i++) {
            num = min + random.nextInt((max - min) + 1);
            xValues[i] = num;
            num = min + random.nextInt((max - min) + 1);
            yValues[i] = num;
        }

        while(true) {
            game.moveBall();
            game.repaint();

            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        new Game04();
    }

    class Game04Panel extends JPanel {

        public Game04Panel() {

            //layout manager will is used for JTextArea only
            setLayout(new GridBagLayout());
            JTextArea quoteText = new JTextArea();
            quoteText.setText("Default Text");
            add(quoteText);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Sets anti-antialiasing
                    RenderingHints.VALUE_ANTIALIAS_ON);           // for drawing the tool

            for(int i = 0; i < 9; i++) {
                g2d.setColor(Color.GREEN);
                g2d.fillOval(xValues[i],yValues[i],30,30);
            }
        }

        private void moveBall() {

            for(int i = 0; i < 9; i++) {
                if((xValues[i] + xa[i]) < 0) {
                    xa[i] = 1;
                }
                if((xValues[i] + xa[i]) > (getWidth() - 30)) {
                    xa[i] = -1;
                }
                if((yValues[i] + ya[i]) < 0) {
                    ya[i] = 1;
                }
                if((yValues[i] + ya[i]) > (getHeight() - 30)) {
                    ya[i] = -1;
                }

                xValues[i] = xValues[i] + xa[i];
                yValues[i] = yValues[i] + ya[i];

            }
        }
    }
}