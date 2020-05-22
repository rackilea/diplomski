import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
/**
 * View which constructs every component and creates it's own controller.
 */
public class SudokuView extends JFrame {

    SudokuController controller;

    public void setSudokuImplementation(SudokuImplementation listener) {
        controller.setListener(listener);
    }

    /** Creates new form NewJFrame */
    public SudokuView() {
        controller = new SudokuController();
        setTitle("Sudoku Solver 1.0");
        getContentPane().add(createCenterPanel(), BorderLayout.CENTER);
        getContentPane().add(createBottomPanel(), BorderLayout.SOUTH);
        setMinimumSize(new Dimension(600, 300));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        JLabel leftLabel = createLabel("left");
        JLabel rightLabel = createLabel("right");

        controller.bindLeftLabel(leftLabel);
        controller.bindRightLabel(rightLabel);

        bottomPanel.add(leftLabel, getWholeCellConstraints());
        bottomPanel.add(new JSeparator(JSeparator.VERTICAL));
        bottomPanel.add(rightLabel, getWholeCellConstraints());

        bottomPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        return bottomPanel;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(createLeftPanel(), getWholeCellConstraints());
        centerPanel.add(createCenterButton(), getPreferredSizeConstraint());
        centerPanel.add(createRightPanel(), getWholeCellConstraints());
        return centerPanel;
    }

    private GridBagConstraints getPreferredSizeConstraint() {
        // default will do
        return new GridBagConstraints();
    }

    private JButton createCenterButton() {
        JButton goButton = new JButton(">");
        controller.bindCenterButton(goButton);
        return goButton;
    }
    private static final Insets sixPixelInset = new Insets(6, 6, 6, 6);

    private JPanel createRightPanel() {
        JPanel rightPanel = create3x3Panel(6);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel panel2 = create3x3Panel(2);
                fillPanelWithNonEditable(panel2, i, j);
                rightPanel.add(panel2);

            }
        }
        rightPanel.setBorder(new EmptyBorder(sixPixelInset));
        return rightPanel;
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = create3x3Panel(6);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel panel2 = create3x3Panel(2);
                fillPanelWithEditable(panel2, i, j);
                leftPanel.add(panel2);

            }
        }
        leftPanel.setBorder(new EmptyBorder(sixPixelInset));
        return leftPanel;
    }

    private GridBagConstraints getWholeCellConstraints() {
        GridBagConstraints wholePanelCnstr = getPreferredSizeConstraint();
        wholePanelCnstr.fill = java.awt.GridBagConstraints.BOTH;
        wholePanelCnstr.weightx = 1.0;
        wholePanelCnstr.weighty = 1.0;
        return wholePanelCnstr;
    }

    private void fillPanelWithEditable(JPanel panel, int majorRow, int majorColumn) {
        for (int minorRow = 0; minorRow < 3; minorRow++) {
            for (int minorColumn = 0; minorColumn < 3; minorColumn++) {
                final JFormattedTextField editableField = createEditableField();
                int column = majorColumn * 3 + minorColumn;
                int row = majorRow * 3 + minorRow;
                controller.bindLeftSudokuCell(row, column, editableField);
                panel.add(editableField);
            }
        }
    }

    private void fillPanelWithNonEditable(JPanel panel, int majorRow, int majorColumn) {
        for (int minorRow = 0; minorRow < 3; minorRow++) {
            for (int minorColumn = 0; minorColumn < 3; minorColumn++) {
                final JFormattedTextField editableField = createNonEditableField();
                int column = majorColumn * 3 + minorColumn;
                int row = majorRow * 3 + minorRow;
                controller.bindRightSudokuCell(row, column, editableField);
                panel.add(editableField);
            }
        }
    }

    private JPanel create3x3Panel(int gap) {
        final GridLayout gridLayout = new GridLayout(3, 3, 1, 1);
        gridLayout.setHgap(gap);
        gridLayout.setVgap(gap);
        JPanel panel = new JPanel(gridLayout);
        return panel;
    }

    private JFormattedTextField createNonEditableField() {
        JFormattedTextField field = createEditableField();
        field.setEditable(false);
        field.setBackground(Color.WHITE); // otherwise non-editable gets gray
        return field;
    }

    private JFormattedTextField createEditableField() {
        JFormattedTextField field = new JFormattedTextField();
        // accept only one digit and nothing else
        try {
            field.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
        }
        field.setPreferredSize(new Dimension(16, 30));
        field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        field.setText(" ");
        field.setBorder(null);
        return field;
    }
}