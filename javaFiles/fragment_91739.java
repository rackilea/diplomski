import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game2 extends JPanel {
    private static final String CPU_PATH = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/"
            + "Gorilla-thinclient.svg/50px-Gorilla-thinclient.svg.png";
    private static final String PERSON_PATH = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/"
            + "Emblem-person-blue.svg/50px-Emblem-person-blue.svg.png";
    private static final int SQR_WIDTH = 50;
    private static final int SIDES = 10;
    private static final Dimension SQR_SIZE = new Dimension(SQR_WIDTH, SQR_WIDTH);
    private static final Color DARK = new Color(149, 69, 53);
    private static final Color LIGHT = new Color(240, 220, 130);
    private JLabel[][] labelGrid = new JLabel[SIDES][SIDES];
    private Icon playerIcon;
    private Icon computerIcon;

    public Game2() throws IOException {
        // would use images instead
        playerIcon = createIcon(PERSON_PATH);
        computerIcon = createIcon(CPU_PATH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new StartAction("Start", KeyEvent.VK_S)));
        buttonPanel.add(new JButton(new UpAction("Up", KeyEvent.VK_U)));
        buttonPanel.add(new JButton(new LeftAction("Left", KeyEvent.VK_L)));

        JPanel gameBrd = new JPanel(new GridLayout(SIDES, SIDES));
        gameBrd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int i = 0; i < labelGrid.length; i++) {
            for (int j = 0; j < labelGrid[i].length; j++) {
                JLabel label = new JLabel();
                label.setPreferredSize(SQR_SIZE);
                label.setOpaque(true);
                Color c = i % 2 == j % 2 ? DARK : LIGHT;
                label.setBackground(c);
                gameBrd.add(label);
                labelGrid[i][j] = label;
            }
        }

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.PAGE_START);
        add(gameBrd);

        // random placement, just for example
        labelGrid[4][4].setIcon(computerIcon);
        labelGrid[5][5].setIcon(playerIcon);
    }

    private Icon createIcon(String path) throws IOException {
        URL url = new URL(path);
        BufferedImage img = ImageIO.read(url);
        return new ImageIcon(img);        
    }

    private abstract class MyAction extends AbstractAction {
        public MyAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
    }

    private class StartAction extends MyAction {
        public StartAction(String name, int mnemonic) {
            super(name, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO start game code

        }
    }

    // move all icons up
    private class UpAction extends MyAction {
        public UpAction(String name, int mnemonic) {
            super(name, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // collection to hold label that needs to be moved
            Map<JLabel, Icon> labelMap = new HashMap<>();
            for (int i = 0; i < labelGrid.length; i++) {
                for (int j = 0; j < labelGrid[i].length; j++) {
                    Icon icon = labelGrid[i][j].getIcon();
                    if (icon != null) {
                        int newI = i == 0 ? labelGrid.length - 1 : i - 1;
                        labelGrid[i][j].setIcon(null);
                        labelMap.put(labelGrid[newI][j], icon);
                    }
                }
            }

            // move the icon after the iteration complete so as not to move it twice
            for (JLabel label : labelMap.keySet()) {
                label.setIcon(labelMap.get(label));
            }
        }
    }

    // move all icons left
    private class LeftAction extends MyAction {
        public LeftAction(String name, int mnemonic) {
            super(name, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Map<JLabel, Icon> labelMap = new HashMap<>();
            for (int i = 0; i < labelGrid.length; i++) {
                for (int j = 0; j < labelGrid[i].length; j++) {
                    Icon icon = labelGrid[i][j].getIcon();
                    if (icon != null) {
                        int newJ = j == 0 ? labelGrid[i].length - 1 : j - 1;
                        labelGrid[i][j].setIcon(null);
                        labelMap.put(labelGrid[i][newJ], icon);
                    }
                }
            }
            for (JLabel label : labelMap.keySet()) {
                label.setIcon(labelMap.get(label));
            }
        }

    }

    private static void createAndShowGui() {
        Game2 mainPanel = null;
        try {
            mainPanel = new Game2();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JFrame frame = new JFrame("Game2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}