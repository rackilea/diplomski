import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PrintFrame {

    public static void main(String[] args) {
        new PrintFrame();
    }

    public PrintFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JLabel label = new JLabel("Clap if you're happy");

                final JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(label);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);

                InputMap im = label.getInputMap(JLabel.WHEN_IN_FOCUSED_WINDOW);
                ActionMap am = label.getActionMap();

                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), "Print");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK | KeyEvent.ALT_DOWN_MASK), "PrintAll");

                am.put("Print", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            System.out.println("Print...");
                            BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
                            Graphics2D g2d = img.createGraphics();
                            frame.printAll(g2d);
                            g2d.dispose();
                            ImageIO.write(img, "png", new File("Print.png"));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                am.put("PrintAll", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            System.out.println("PrintAll...");
                            Robot bot = new Robot();
                            Rectangle bounds = frame.getBounds();
                            bounds.x -= 2;
                            bounds.y -= 2;
                            bounds.width += 4;
                            bounds.height += 4;
                            BufferedImage img = bot.createScreenCapture(bounds);
                            ImageIO.write(img, "png", new File("PrintAll.png"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                frame.setVisible(true);

            }
        });
    }
}