import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.Timer;

class SimpleTest implements ActionListener{

    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final int DELAY = 500;

    private Integer[][] data = null;
    private int currCol;
    private int currRow;
    private JTable tableToFill = null;
    private Timer theTimer = null;

    /**
     * Calculates the data that should be displayed in the table.
     * In this case it's a simple multiplication table.
     */
    public void fillData() {
        data = new Integer[ROWS][COLS];
        for ( int row = 0; row < ROWS; row++ ) {
            for ( int col = 0; col < COLS; col++) {
                data[row][col] = (row + 1) * (col + 1);
            }
        }
    }

    /**
     * Creates a GUI table to fill up.
     * @return The table object created.
     */
    public JTable setUpJTable() {
        tableToFill = new JTable(ROWS,COLS);
        return tableToFill;
    }

    /**
     * Starts the timer that fills the values in the GUI table
     */
    public void startTimer() {
        if ( tableToFill != null && data != null ) {
            currCol = 0;
            currRow = 0;
            theTimer = new Timer( DELAY, this);
            theTimer.start();
        }
    }

    /**
     * Called by the timer to set the value in the table.
     * 
     * @param evt Action event (not used)
     */
    public void actionPerformed(ActionEvent evt) {
        synchronized (this) {
            if ( currRow < ROWS ) {
                tableToFill.setValueAt(data[currRow][currCol], currRow, currCol);
                currCol++;
                if ( currCol == COLS ) {
                    currCol = 0;
                    currRow++;
                }

            } else {
                theTimer.stop();
            }
        }
    }

    public static void main(String[] args) {

        SimpleTest tableFiller = new SimpleTest();
        JTable table = tableFiller.setUpJTable();

        // Display the table

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
        frame.getContentPane().add(table, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // Fill the data, then start displaying it gradually

        tableFiller.fillData();
        tableFiller.startTimer();
    }


}