import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.net.URL;

public class TicTacToeButtons {

    private JComponent ui = null;
    private String path = "https://i.stack.imgur.com/sAU9n.png";
    private BufferedImage image;
    Image transparentImage;

    private JButton getButton(int i) {
        Image img = (i%2==0 ? image : transparentImage);
        JButton b = new JButton(new ImageIcon(img));
        b.setBorder(null);
        return b;
    }

    TicTacToeButtons() {
        try {
            initUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void initUI() throws Exception {
        if (ui!=null) return;

        image = ImageIO.read(new URL(path));
        transparentImage = new BufferedImage(
                image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB);

        ui = new JPanel(new GridLayout(3,3));
        ui.setBorder(new EmptyBorder(4,4,4,4));
        for (int ii=0; ii<9; ii++) {
            ui.add(getButton(ii));
        }
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                TicTacToeButtons o = new TicTacToeButtons();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}