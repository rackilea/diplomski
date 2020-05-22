import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
                frame.add(new Brewery());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Brewery extends JPanel {

        public Brewery() {
            setBackground(Color.WHITE);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            try {

                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.SOUTH;
                JPanel top = new JPanel(new GridLayout(1, 2));
                top.setOpaque(false);
                top.add(new Silo());
                top.add(new Silo());
                add(top, gbc);

                gbc.gridy++;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                add(new Pipe(), gbc);

                gbc.anchor = GridBagConstraints.NORTH;
                gbc.gridy++;
                gbc.gridwidth = 1;
                JPanel bottom = new JPanel(new GridLayout(1, 2));
                bottom.setOpaque(false);
                bottom.add(new Silo());
                bottom.add(new Silo());
                add(bottom, gbc);
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }

    public class Silo extends JComponent {

        BufferedImage img;

        public Silo() throws IOException {
            setBorder(new EmptyBorder(0, 50, 0, 50));
            img = ImageIO.read(new File("img/EmptySilo.png"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight() - img.getHeight()) / 2;
            g.drawImage(img, x, y, this);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension dim = new Dimension(100, 100);
            if (img != null) {
                dim = new Dimension(img.getWidth(), img.getHeight());
            }
            Insets insets = getInsets();
            dim.width += insets.left + insets.right;
            dim.height += insets.top + insets.bottom;
            return dim;
        }

        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

    }


    public class Pipe extends JComponent {

        BufferedImage img;

        public Pipe() throws IOException {
            img = ImageIO.read(new File("img/Pipe.png"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight() - img.getHeight()) / 2;
            g.drawImage(img, x, y, this);
        }

        @Override
        public Dimension getPreferredSize() {
            if (img == null) {
                return new Dimension(100, 100);
            } else {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        }

        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

    }
}