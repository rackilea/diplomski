import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel player;

        public TestPane() throws IOException {
            BufferedImage tileImg = ImageIO.read(getClass().getResource("Tile.jpg"));
            BufferedImage playerImg = ImageIO.read(getClass().getResource("Mario.png"));
            Icon tileIcon = new ImageIcon(tileImg);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            player = new JLabel(new ImageIcon(playerImg));
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(player, gbc);
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;
                    add(new JLabel(tileIcon), gbc);
                }
            }

            Timer timer = new Timer(500, new ActionListener() {
                private int x = 0;
                private int y = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    x++;
                    if (x > 9) {
                        x = 0;
                        y++;
                    }
                    if (y > 9) {
                        y = 0;
                    }
                    GridBagLayout layout = (GridBagLayout) getLayout();
                    GridBagConstraints gbc = layout.getConstraints(player);
                    gbc.gridx = x;
                    gbc.gridy = y;
                    layout.setConstraints(player, gbc);
                    revalidate();
                }
            });
            timer.start();
        }

    }

}