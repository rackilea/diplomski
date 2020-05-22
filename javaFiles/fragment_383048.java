import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.guiConfig();
                gui.labelPositioning();
                gui.frameVisibility();
            }
        });
    }

    public class GUI {

        final int screenX = 1280, screenY = 720;

        JFrame mainGui = new JFrame();

        JPanel gamePanel = new JPanel();
        JPanel shopPanel = new JPanel();

        JButton userName = new JButton("userName"); // this is the area for the user's username they input in
        JButton cookieCounter = new JButton("cookieCounter"); // this is the counter for how many cookies the user currently has
        JButton cookieClick = new JButton("cookieClick"); // this is the label for the cookie we click on
        JButton shopButton = new JButton("shopButton"); // this takes us to the shop, probably some if statement and set visible etc.

        GridBagConstraints gameLayout = new GridBagConstraints();

        public void guiConfig() {
            mainGui.setSize(screenX, screenY);
            mainGui.setTitle("journey");
            mainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            mainGui.setResizable(false);
            mainGui.setBackground(Color.WHITE);
            mainGui.add(gamePanel);

//            gamePanel.setSize(screenX, screenY);
            gamePanel.setLayout(new GridBagLayout());
        }

        public void labelPositioning() {
            gameLayout.fill = GridBagConstraints.HORIZONTAL;
            gameLayout.gridx = 0;
            gameLayout.gridwidth = 2;
            gameLayout.gridy = 0;
            gameLayout.weightx = 2.0;
            gameLayout.weighty = 1.0;
            gamePanel.add(cookieCounter, gameLayout);

            gameLayout.fill = GridBagConstraints.HORIZONTAL;
            gameLayout.gridx = 0;
            gameLayout.gridwidth = 1;
            gameLayout.gridy = 0;
            gameLayout.weightx = 1.0;
            gameLayout.weighty = 1.0;
            gamePanel.add(new JLabel(), gameLayout);

            gameLayout.fill = GridBagConstraints.HORIZONTAL;
            gameLayout.gridx = 2;
            gameLayout.gridwidth = 1;
            gameLayout.gridy = 0;
            gameLayout.weightx = 1.0;
            gameLayout.weighty = 1.0;
            gamePanel.add(userName, gameLayout);

            gameLayout.fill = GridBagConstraints.HORIZONTAL;
            gameLayout.gridx = 1;
            gameLayout.gridwidth = 1;
            gameLayout.gridy = 1;
            gameLayout.weightx = 1.0;
            gameLayout.weighty = 1.0;
            gamePanel.add(cookieClick, gameLayout);

            gameLayout.fill = GridBagConstraints.HORIZONTAL;
            gameLayout.gridx = 1;
            gameLayout.gridwidth = 1;
            gameLayout.gridy = 2;
            gameLayout.weightx = 1.0;
            gameLayout.weighty = 1.0;
            gamePanel.add(shopButton, gameLayout);
        }

        public void frameVisibility() {
            mainGui.setVisible(true);
        }
    }
}