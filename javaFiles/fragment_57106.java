import java.awt.Color;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TestTransparentButton {

    protected void createAndShowGUI() throws MalformedURLException, IOException {
        JFrame frame = new JFrame("Test button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final BufferedImage image = ImageIO.read(new URL("http://i.stack.imgur.com/7D547.png"));
        final JButton button = new JButton(new ImageIcon(image)) {
            @Override
            public boolean contains(int x, int y) {
                Rectangle viewRect = getBounds();
                Insets insets = getInsets();
                viewRect.x = insets.left;
                viewRect.y = insets.top;
                viewRect.width -= insets.left + insets.right;
                viewRect.height -= insets.top + insets.bottom;
                Rectangle iconR = new Rectangle();
                SwingUtilities.layoutCompoundLabel(this, this.getFontMetrics(this.getFont()), this.getText(), this.getIcon(),
                        this.getVerticalAlignment(), this.getHorizontalAlignment(), this.getVerticalTextPosition(),
                        this.getHorizontalTextPosition(), viewRect, iconR, new Rectangle(), this.getIconTextGap());
                if (!iconR.contains(x, y)) {
                    return false;
                }
                x -= iconR.x;
                y -= iconR.y;
                Color c = new Color(image.getRGB(x, y), true);
                return c.getAlpha() != 0 && (c.getRed() < 255 || c.getGreen() < 255 || c.getBlue() < 255);
            }
        };
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button, "You clicked on the button");
            }
        });
        frame.add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TestTransparentButton().createAndShowGUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

}