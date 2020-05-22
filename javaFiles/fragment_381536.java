import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FoodMenu {
    private JFrame frame;
    private JPanel pane;
    private GridBagConstraints gbc;
    private JLabel[] foodLabel;
    private JTextField[] qtyField;

    private static final int ELEMENTS = 9;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FoodMenu().createAndShowGui());
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        pane = new JPanel();
        pane.setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();

        foodLabel = new JLabel[ELEMENTS];
        qtyField = new JTextField[ELEMENTS];

        ImageIcon icon = null, icon2 = null;
        try {
            URL url = new URL("https://image.flaticon.com/icons/png/128/148/148836.png");
            URL url2 = new URL("https://i.stack.imgur.com/IucNt.png");
            BufferedImage img = ImageIO.read(url);
            icon = new ImageIcon(img);
            BufferedImage img2 = ImageIO.read(url2);
            icon2 = new ImageIcon(img2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < ELEMENTS; i++) {
            foodLabel[i] = new JLabel(i % 2 == 0 ? icon : icon2);
            qtyField[i] = new JTextField(3);
        }

        gbc.gridx = 0;
        for (int i = 0; i < ELEMENTS; i++) {
            if (i % 3 == 0) {
                gbc.gridy++;
                gbc.gridx = 0;
            }
            pane.add(foodLabel[i], gbc);

            gbc.gridx++;
            pane.add(qtyField[i], gbc);
            gbc.gridx++;
        }

        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}