import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    Random dice = new Random();

    public Main() {
        Vector<String> columNames = new Vector<>();
        columNames.add("index");
        columNames.add("years");
        columNames.add("weight");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        JTable table = new JTable();
        makeModel(table, columNames);
        MyFrame frame = new MyFrame(table);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeModel(table, columNames);
            }
        });
        timer.start();
    }

    protected void makeModel(JTable table, Vector columnNames) {
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (int x = 0; x < 3; x++) {
            Vector row = new Vector();
            for (int y = 0; y < model.getColumnCount(); y++) {
                row.add(dice.nextInt(10));
            }
            model.addRow(row);
        }
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        RowSorter<? extends TableModel> oldSorter = table.getRowSorter();
        if (oldSorter != null) {
            sorter.setSortKeys(oldSorter.getSortKeys());
        }

        table.setModel(model);
        table.setRowSorter(sorter);
    }

    public static class MyFrame extends JFrame {

        JTable table;
        Dimension dim = new Dimension(300, 500);
        JScrollPane pane;
        Vector<String> columNames = new Vector<>();
        Vector<Vector<Object>> dataVector;
        int[] i = {0, 1, -1};

        public MyFrame(JTable table) {
            pane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            setSize(300, 500);
            setPreferredSize(dim);
            setMinimumSize(dim);
            setTitle("Failing autoupdate of JTable");
            setBackground(Color.BLACK);
            add(pane);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }
}