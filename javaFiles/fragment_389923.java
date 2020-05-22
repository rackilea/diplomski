import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SwingTest extends JFrame{
    private JTable table = new JTable();
    private JScrollPane scroll = new JScrollPane(table);
    private DefaultTableModel tm = new DefaultTableModel(new String[]{"a","b","c"},2);

    public SwingTest() {
        table.setModel(tm);
        table.setDropTarget(new DropTarget(){
            @Override
            public synchronized void drop(DropTargetDropEvent dtde) {
                Point point = dtde.getLocation();
                int column = table.columnAtPoint(point);
                int row = table.rowAtPoint(point);
                // handle drop inside current table
                super.drop(dtde);
            }
        });
        scroll.setDropTarget(new DropTarget(){
            @Override
            public synchronized void drop(DropTargetDropEvent dtde) {
                // handle drop outside current table (e.g. add row)
                super.drop(dtde);
            }
        });
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(scroll);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingTest();
    }
}