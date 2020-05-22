import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.Timer;

public class TestTable {

    private Timer showTimer;
    private Timer disposeTimer;
    private JTable table;
    private Point hintCell;
    private MyPopup popup; // Inherites from JPopupMenu

    public TestTable() {

        showTimer = new Timer(1500, new ShowPopupActionHandler());
        showTimer.setRepeats(false);
        showTimer.setCoalesce(true);

        disposeTimer = new Timer(5000, new DisposePopupActionHandler());
        disposeTimer.setRepeats(false);
        disposeTimer.setCoalesce(true);

        table.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {

                Point p = e.getPoint();
                int row = table.rowAtPoint(p);
                int col = table.columnAtPoint(p);

                if ((row > -1 && row < table.getRowCount()) && (col > -1 && col < table.getColumnCount())) {

                    if (hintCell == null || (hintCell.x != col || hintCell.y != row)) {

                        hintCell = new Point(col, row);
                        Object value = table.getValueAt(row, col);
                        // Depending on how the data is stored, you may need to load more data
                        // here...
                        // You will probably want to maintain a reference to the object hint data

                        showTimer.restart();

                    }

                }

            }
        });

    }

    protected MyPopup getHintPopup() {

        if (popup == null) {

            // Construct the popup...

        }

        return popup;

    }

    public class ShowPopupActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (hintCell != null) {

                disposeTimer.stop(); // don't want it going off while we're setting up

                MyPopup popup = getHintPopup();
                popup.setVisible(false);

                // You might want to check that the object hint data is update and valid...
                Rectangle bounds = table.getCellRect(hintCell.y, hintCell.x, true);
                int x = bounds.x;
                int y = bounds.y + bounds.height;

                popup.show(table, x, y);

                disposeTimer.start();

            }

        }
    }

    public class DisposePopupActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            MyPopup popup = getHintPopup();
            popup.setVisible(false);

        }
    }
}