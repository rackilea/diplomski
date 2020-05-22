import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class SudokuController {

    JLabel leftLabel, rightLabel;
    JFormattedTextField[][] leftSudoku, rightSudoku;
    JButton goButton;

    public SudokuController() {
        leftSudoku = new JFormattedTextField[9][9]; // standard sudoku size
        rightSudoku = new JFormattedTextField[9][9];
    }

    void bindLeftLabel(JLabel label) {
        leftLabel = label;
    }

    void bindRightLabel(JLabel label) {
        rightLabel = label;
    }

    void bindLeftSudokuCell(final int row, final int column, JFormattedTextField field) {
        field.addPropertyChangeListener("value", new PropertyChangeListener() {

            // if user edits field than You could do something about it here
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getNewValue() != null) {
                    String newValue = (String) evt.getNewValue();
                    userEditedValueAt(row, column, Integer.valueOf(newValue));
                }
            }
        });
        leftSudoku[row][column] = field;
    }

    void userEditedValueAt(int row, int column, int value) {
        System.out.println("Value changed at row:" + row + ", column:" + column + " to " + value);
    }

    void bindRightSudokuCell(int row, int column, JFormattedTextField field) {
        rightSudoku[row][column] = field;
    }

    void spitOutSudokus() {
        System.out.println("Left:");
        System.out.println(getPrettyPrinted(leftSudoku));
        System.out.println("Right:");
        System.out.println(getPrettyPrinted(rightSudoku));
    }

    private String getPrettyPrinted(JFormattedTextField[][] sudoku) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append("|");
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != null) {
                    sb.append(sudoku[i][j].getText());
                } else {
                    sb.append("-");
                }
                sb.append(" ");
            }
            sb.append("|\n");
        }
        return sb.toString();
    }

    void bindCenterButton(JButton goButton) {
        this.goButton = goButton;
        goButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                goButtonPressed();
            }
        });
    }
    SudokuImplementation listener;

    public void setListener(SudokuImplementation listener) {
        this.listener = listener;
    }
    Thread backGroundThread;

    private void goButtonPressed() {
        if (listener != null) {
            if (backGroundThread == null || (backGroundThread != null && !backGroundThread.isAlive())) {
                backGroundThread = new Thread() {

                    @Override
                    public void run() {
                        listener.goButtonPressed(getLeftValues(), SudokuController.this);
                    }
                };
                backGroundThread.start();
            }
        }
    }

    private Integer[][] getLeftValues() {
        Integer[][] values = new Integer[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!leftSudoku[i][j].getText().equals(" ")) {
                    values[i][j] = Integer.valueOf(leftSudoku[i][j].getText());
                }
            }
        }
        return values;
    }

    public void setSudokuResult(final Integer[][] result) {
        // Any GUI interaction must be done on EDT
        // We don't want to block computation so we choose invokeLater
        // as opposed to invokeAndWait.
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        rightSudoku[i][j].setValue(String.valueOf(result[i][j]));
                    }
                }
            }
        });
    }

    public void setSudokuTime(final String time) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                leftLabel.setText("<html>Running time: <b>" + time);
            }
        });
    }

    public void setSudokuCompleted(final boolean completed) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {

                rightLabel.setText("<html>Completely Solved: <b>" + completed);
                if (completed) {
                    spitOutSudokus();
                }

            }
        });
    }
}