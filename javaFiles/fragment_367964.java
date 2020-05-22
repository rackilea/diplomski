import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Game2 extends JPanel {

    private static final int BOX_W = 400;
    private static final int BOX_H = BOX_W;
    private static final Color SIDE_BG = Color.GRAY;
    private JLabel moneyLabel = new JLabel("$20.00");

    public Game2() {
        JButton exitButton = new JButton("Exit");
        JPanel exitBtnPanel = new JPanel();
        exitBtnPanel.add(exitButton);
        exitBtnPanel.setOpaque(false);
        int eb = 2;
        exitBtnPanel.setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));

        JPanel moneyPanel = new JPanel();
        moneyPanel.add(moneyLabel);
        moneyPanel.setOpaque(false);

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(SIDE_BG);
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
        sidePanel.add(exitBtnPanel);
        sidePanel.add(moneyPanel);

        setLayout(new BorderLayout());
        add(Box.createRigidArea(new Dimension(BOX_W, BOX_H)));
        add(sidePanel, BorderLayout.LINE_END);
    }

    private static void createAndShowGui() {
        Game2 mainPanel = new Game2();

        JFrame frame = new JFrame("Game2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}