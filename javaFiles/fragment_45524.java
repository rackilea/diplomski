import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Main extends JFrame {

    public static void main(String[] args0) {

        try {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

            frame.getContentPane().setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 0.9;
            gbc.weighty = 0.9;
            gbc.fill = GridBagConstraints.BOTH;

            URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
            ImageIcon image = new ImageIcon(url);
            JLabel imageLabel = new JLabel(image);
            frame.add(imageLabel, gbc);

            gbc.weightx = 0.9;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.NONE;

            JButton b = new JButton("Click Here");
            frame.add(b, gbc);

            frame.pack();
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}