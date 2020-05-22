import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class SimpleSudokuPanel extends JPanel {
    private static final int PANEL_THICKNESS = 2;
    private static final int TF_THICKNESS = 1;
    private static final int TF_COLS = 2;
    private static final float TF_PTS = 36f;
    private JTextField[][] grid = new JTextField[9][9];

    public SimpleSudokuPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 3));
        JPanel[] innerPanels = new JPanel[9];
        for (int i = 0; i < innerPanels.length; i++) {
            innerPanels[i] = new JPanel(new GridLayout(3, 3));
            innerPanels[i].setBorder(BorderFactory.createLineBorder(Color.black, PANEL_THICKNESS));
            mainPanel.add(innerPanels[i]);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new JTextField(TF_COLS);
                grid[i][j].setFont(grid[i][j].getFont().deriveFont(Font.BOLD, TF_PTS));
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black, TF_THICKNESS));
                grid[i][j].setHorizontalAlignment(JTextField.CENTER);
                int panelIndex = 3 * (i / 3) + j / 3;
                innerPanels[panelIndex].add(grid[i][j]);
            }
        }

        setBorder(BorderFactory.createLineBorder(Color.black, PANEL_THICKNESS));
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("SimpleSudokuPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SimpleSudokuPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}