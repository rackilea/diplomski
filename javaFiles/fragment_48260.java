import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class ScrollPaneFun2 extends JPanel {

    private static final int PREF_W = 500;

    public ScrollPaneFun2() {
        JPanel topPanel = new JPanel(new GridLayout(0, 1));
        JPanel botPanel = new JPanel(new GridLayout(0, 1));

        for (int i = 0; i < 3; i++) {
            JPanel innerTopPanel = new JPanel(new GridLayout(1, 0, 3, 0));
            JPanel innerBotPanel = new JPanel(new GridLayout(1, 0, 3, 0));
            for (int j = 0; j < 50; j++) {
                innerTopPanel.add(new JLabel("Text " + (i + 1)));
                innerBotPanel.add(new JLabel("Text " + (i + 1)));
            }
            topPanel.add(innerTopPanel);
            botPanel.add(innerBotPanel);
        }

        JScrollPane topScrollPane = new JScrollPane(topPanel);
        JScrollPane botScrollPane = new JScrollPane(botPanel);
        topScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        botScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        setLayout(new GridLayout(0, 1));
        add(topScrollPane);
        add(botScrollPane);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        int height = super.getPreferredSize().height;
        return new Dimension(PREF_W, height);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("ScrollPaneFun2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ScrollPaneFun2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}