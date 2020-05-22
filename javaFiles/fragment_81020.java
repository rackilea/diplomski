import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutTest extends JPanel {
    private static final int CELL_WIDTH = 100;
    private static final int SIDES = 5;
    private static final int GAP = 25;
    private static final Color BG = Color.WHITE;
    private LayoutPanel layoutPanel = new LayoutPanel(CELL_WIDTH, SIDES);

    public LayoutTest() {
        setBackground(BG);
        JPanel btnPanel = new JPanel(new GridLayout(1, 0, GAP, GAP));
        btnPanel.add(new JButton("Button 1"));
        btnPanel.add(new JButton("Button 2"));
        btnPanel.setBackground(BG);

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(layoutPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_START);
    }

    private static void createAndShowGui() {
        LayoutTest mainPanel = new LayoutTest();

        JFrame frame = new JFrame("Layout Test");
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

@SuppressWarnings("serial")
class LayoutPanel extends JPanel {
    private static final Color BG = Color.BLACK;
    private int sides = 5;
    private static final int INNER_GAP = 1;
    private static final Color CELL_BG = Color.WHITE;

    public LayoutPanel(int cellWidth, int sides) {
        setBackground(BG);
        setBorder(BorderFactory.createLineBorder(BG));
        this.sides = sides;
        setLayout(new GridLayout(sides, sides, INNER_GAP, INNER_GAP));
        Dimension cellDim = new Dimension(cellWidth, cellWidth);
        for (int i = 0; i < sides * sides; i++) {
            JLabel label = new JLabel(".", SwingConstants.CENTER);
            label.setPreferredSize(cellDim);
            label.setBackground(CELL_BG);
            label.setOpaque(true);
            add(label);
        }
    }
}