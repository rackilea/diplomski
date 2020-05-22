import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BackgroundList {

    public static void main(String[] args) {
        new BackgroundList();
    }

    public BackgroundList() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JList list;
        private BufferedImage background;

        public TestPane() {
            setLayout(new BorderLayout());
            try {
                background = ImageIO.read(new File("C:\\Users\\shane\\Dropbox\\MegaTokyo\\_cg_836___Tilting_Windmills___by_Serena_Clearwater.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            int count = 50;
            String[] values = new String[count];
            for (int index = 0; index < count; index++) {
                values[index] = "Testing " + (index + 1);
            }

            list = new BackgroundImageList(values);

            JScrollPane scrollPane = new JScrollPane(list);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);

            add(scrollPane);

        }
    }

    public class BackgroundImageList extends JList {
        private BufferedImage background;

        public BackgroundImageList(Object[] values) {
            super(values);
            try {
                background = ImageIO.read(new File("C:\\Users\\shane\\Dropbox\\MegaTokyo\\_cg_836___Tilting_Windmills___by_Serena_Clearwater.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));
            setForeground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = getWidth() - background.getWidth();
                int y = getHeight() - background.getHeight();
                g2d.drawImage(background, x, y, this);
                g2d.dispose();
            }
            super.paintComponent(g);
        }

    }
}