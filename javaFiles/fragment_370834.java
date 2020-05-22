import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game {

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new GamePane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class GamePane extends JPanel {

        public GamePane() throws IOException {
            initialize();

        }

        private void initialize() throws IOException {
            Square x = new Square("images\\black-X.png", "images\\blue-X.png", "x");
            Square o = new Square("images\\black-O.png", "images\\blue-O.png", "o");
            Square sq = new Square("images\\black-sq.png", "images\\blue-sq.png", "sq");
            Square tri = new Square("images\\black-tri.png", "images\\blue-tri.png", "tri");

            setLayout(new GridLayout(2, 2));

            add(x);
            add(o);
            add(sq);
            add(tri);
        }

    }

    public class ClickListener extends MouseAdapter {

        private Square ob;

        public ClickListener(Square newSquare) {
            ob = newSquare;
        }

        public void mouseClicked(MouseEvent e) {
            ob.changePic();
        }

    }

    public class Square extends JLabel {

        String name;
        private BufferedImage myPic1, myPic2;

        public Square(String pic1, String pic2, String name) throws IOException {
            this.name = name;

            myPic1 = ImageIO.read(new File(pic1));
            myPic2 = ImageIO.read(new File(pic2));

            setIcon(new ImageIcon(myPic1));
            addMouseListener(new ClickListener(this));
        }

        public String getName() {
            return this.name;
        }

        public void changePic() {
            setIcon(new ImageIcon(myPic2));
        }
    }
}