import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;    
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MetaSpaceLauncherPanel extends JPanel {
    // path to a public starry image
    public static final String IMG_PATH = "https://upload.wikimedia.org/wikipedia/"
            + "commons/thumb/b/be/Milky_Way_at_Concordia_Camp%2C_Karakoram_Range%2"
            + "C_Pakistan.jpg/1280px-Milky_Way_at_Concordia_Camp%2C_Karakoram_Range"
            + "%2C_Pakistan.jpg";
    private static final int I_GAP = 10;

    private static final int COLS = 15;
    private JTextField tfUsername = new JTextField(COLS);
    private JPasswordField tfPassword = new JPasswordField(COLS);
    private BufferedImage background = null;

    public MetaSpaceLauncherPanel(BufferedImage background) {
        this.background = background;

        // close window if enter pressed and data within fields
        ActionListener listener = e -> {
            String userName = tfUsername.getText().trim();
            char[] password = tfPassword.getPassword();

            Window window = SwingUtilities.getWindowAncestor(MetaSpaceLauncherPanel.this);
            if (userName.isEmpty() || password.length == 0) {
                // both fields need to be filled!
                String message = "Both user name and password fields must contain data";
                String title = "Invalid Data Entry";
                JOptionPane.showMessageDialog(window, message, title, JOptionPane.ERROR_MESSAGE);
            } else {
                // simply close the dialog
                window.dispose();
            }
        };

        tfUsername.addActionListener(listener);
        tfPassword.addActionListener(listener);

        JPanel innerPanel = new JPanel(new GridBagLayout());
        innerPanel.setOpaque(false);
        Border outerBorder = BorderFactory.createEtchedBorder();
        Border innerBorder = BorderFactory.createEmptyBorder(I_GAP, I_GAP, I_GAP, I_GAP);
        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        innerPanel.setBorder(border);

        JLabel userNameLabel = new JLabel("User Name:");
        userNameLabel.setForeground(Color.LIGHT_GRAY);
        innerPanel.add(userNameLabel, createGbc(0, 0));
        innerPanel.add(tfUsername, createGbc(1, 0));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.LIGHT_GRAY);
        innerPanel.add(passwordLabel, createGbc(0, 1));
        innerPanel.add(tfPassword, createGbc(1, 1));

        setLayout(new GridBagLayout());
        add(innerPanel); // add without constraints to center it
    }

    public String getUserName() {
        return tfUsername.getText();
    }

    public char[] getPassword() {
        return tfPassword.getPassword();
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL; // stretch components horizontally
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; // increase if you want component location to stretch vert.

        // I_GAP is a constant and is the size of the gap around
        // each component
        gbc.insets = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);

        // if the x value is odd, anchor to the left, otherwise if even to the right
        gbc.anchor = x % 2 == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        return gbc;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || background == null) {
            return super.getPreferredSize();
        }
        int w = background.getWidth();
        int h = background.getHeight();
        return new Dimension(w, h);
    }

    private static void createAndShowGui() {
        BufferedImage img = null;
        try {
            // just using this as an example image, one available to all
            // you would probably use your own image
            URL imgUrl = new URL(IMG_PATH); // online path to starry image
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1); // no image available -- exit!
        }
        MetaSpaceLauncherPanel launcherPanel = new MetaSpaceLauncherPanel(img);

        JDialog dialog = new JDialog(null, "MetaSpace Launcher", ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(launcherPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // test to see if we can get the data
        String userName = launcherPanel.getUserName();
        char[] password = launcherPanel.getPassword();

        // don't convert password into String as I'm doing below as it is now
        // not secure
        String message = String.format("<html>User Name: %s<br/>Password: %s</html>", userName,
                new String(password));
        JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}