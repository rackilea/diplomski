import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class EditorEg extends JPanel {
    private static final int MAX_X = 205;
    private static final int MAX_Y = 280;
    private static final int TA_ROWS = 8;
    private static final int TA_COLS = 16;
    private JSpinner xSpinner = new JSpinner(new SpinnerNumberModel(0, 0, MAX_X, 1));
    private JSpinner ySpinner = new JSpinner(new SpinnerNumberModel(0, 0, MAX_Y, 1));
    private JSpinner angleSpinner = new JSpinner(new SpinnerNumberModel(0, -5, 360, 5));
    private JSpinner widthSpinner = new JSpinner(new SpinnerNumberModel(10, 10, MAX_X, 10));
    private JTextArea textArea = new JTextArea(TA_ROWS, TA_COLS);
    private JButton deleteButton = new JButton("Delete");

    public EditorEg() {
        JPanel xyPanel = new JPanel(new GridBagLayout());
        int gap = 2;
        Insets insets = new Insets(gap, gap, gap, gap);
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        gbc.weightx = 0.2;
        xyPanel.add(new JLabel("x:"), gbc);
        gbc.gridx++;
        gbc.weightx = 1.0;
        xyPanel.add(xSpinner, gbc);
        gbc.gridx++;
        gbc.weightx = 0.2;
        xyPanel.add(new JLabel("y:"), gbc);
        gbc.gridx++;
        gbc.weightx = 1.0;
        xyPanel.add(ySpinner, gbc);

        JPanel angleWidthPanel = new JPanel(new GridBagLayout());
        gap = 3;
        insets = new Insets(gap, gap, gap, gap);
        gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        angleWidthPanel.add(new JLabel("angle:"), gbc);
        gbc.gridx++;
        angleWidthPanel.add(angleSpinner, gbc);
        gbc.gridx--;
        gbc.gridy++;
        angleWidthPanel.add(new JLabel("width:"), gbc);
        gbc.gridx++;
        angleWidthPanel.add(widthSpinner, gbc);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel scrollWrapper = new JPanel(new BorderLayout());
        scrollWrapper.setBorder(BorderFactory.createTitledBorder("Text"));
        scrollWrapper.add(scrollPane);

        setLayout(new GridBagLayout());
        gap = 4;
        setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        insets = new Insets(gap, gap, gap, gap);

        gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        add(xyPanel, gbc);
        gbc.gridy++;
        add(angleWidthPanel, gbc);
        gbc.gridy++;
        add(scrollWrapper, gbc);
        gbc.gridy++;
        add(deleteButton, gbc);
    }

    private static void createAndShowGui() {
        EditorEg mainPanel = new EditorEg();

        JFrame frame = new JFrame("Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}