import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Panel background = new Panel();

                JFrame frame = new JFrame("Testing");
                frame.setContentPane(background);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Gui());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class Panel extends JPanel {

        BufferedImage image;

        public Panel() {
            setLayout(new BorderLayout());
            try {
                image = ImageIO.read(getClass().getResource("/Testumgebung/background/battleship_main.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? super.getPreferredSize() : new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

    }

    public static class Gui extends JPanel {

        private MainMenuPane mainMenuPane;
        private CardLayout cardLayout;

        public Gui() {

            setOpaque(false);

            setVisible(true);
            cardLayout = new CardLayout();
            setLayout(cardLayout);

            mainMenuPane = new MainMenuPane();
            // Other views

            add(mainMenuPane, "MainMenu");

            cardLayout.show(this, "MainMenu");

        }

    }

    public static class MainMenuPane extends JPanel {

        JButton singlePlayerButton;
        JButton multiPlayerButton;

        JLabel text;

        public MainMenuPane() {

            setLayout(new GridBagLayout());
            setOpaque(false);
            setBackground(Color.BLUE);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.ipadx = 20;
            gbc.ipady = 20;

            singlePlayerButton = new JButton("Single Player");

            add(singlePlayerButton, gbc);

            multiPlayerButton = new JButton("Multi Player");

            add(multiPlayerButton, gbc);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // This is faking transparency, so the background color
            // will be see through
            Graphics2D g2d = (Graphics2D) g.create();
            Composite old = g2d.getComposite();
            g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setComposite(old);
        }

    }

}