import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class SimpleSudoku extends JPanel {
    private static final int GAP = 1;
    private static final Font LABEL_FONT = new Font(Font.DIALOG, Font.PLAIN, 24);
    private JLabel[][] grid = new JLabel[9][9];

    public SimpleSudoku() {
        JPanel sudokuPanel = new JPanel(new GridLayout(9, 9, GAP, GAP));
        sudokuPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        sudokuPanel.setBackground(Color.BLACK);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = new JLabel("     ", SwingConstants.CENTER);
                grid[row][col].setFont(LABEL_FONT); // make it big
                grid[row][col].setOpaque(true);
                grid[row][col].setBackground(Color.WHITE);
                sudokuPanel.add(grid[row][col]);
            }
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton("Regenerate"));

        setLayout(new BorderLayout());
        add(sudokuPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }

    private static void createAndShowGui() {
        SimpleSudoku mainPanel = new SimpleSudoku();
        JFrame frame = new JFrame("SimpleSudoku");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}