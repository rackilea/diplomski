import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Qwq {

    public static void main(String[] args) {
        new Qwq();
    }

    public Qwq() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestingGround());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Keyboard extends KeyAdapter {

        private List<Fighter> fighterList;

        public Keyboard(List<Fighter> fighterList) {
            this.fighterList = fighterList;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            fighterList.get(0).setFighterX(500);
            fighterList.get(1).setFighterX(200);
            System.out.print("Updated the x value of two");
        }
    }

    public class TestingGround extends JPanel {

        private ArrayList<Fighter> fighterList = new ArrayList<>(); 

        private Image image;
        private Keyboard keyboard;

        public TestingGround() {
            loadImages();
            addKeyListener(new Keyboard(Collections.unmodifiableList(fighterList)));
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
        }

        public void loadImages() {
            ImageIcon imageIcon = new ImageIcon("C:/Users/destr/workspace/GameWIP3/bin/A2.png");
            image = imageIcon.getImage();
        }

        protected void paintComponent(Graphics g) {//Drawing
            super.paintComponent(g);
            for (Fighter fighter : fighterList) {
                System.out.print("testing");
                g.drawImage(image, fighter.getFighterX(), fighter.getFighterY(), null);
            }
        }
    }

    public static class Fighter {

        private int fighterX;
        private int fighterY;

        public Fighter(int fighterX, int fighterY) {
            this.setFighterX(fighterX);
            this.setFighterY(fighterY);
        }

        public int getFighterX() {
            return fighterX; //method to get x coordinate of a fighter
        }

        public int getFighterY() {
            return fighterY;//method to get y coordinate of a fighter
        }

        public void setFighterX(int fighterX) {
            this.fighterX = fighterX; //method to set the x coordinate of a fighter
        }

        public void setFighterY(int fighterY) {
            this.fighterY = fighterY; //method to set the y coordinate of a fighter
        }
    }
}