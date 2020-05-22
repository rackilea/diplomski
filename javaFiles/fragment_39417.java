import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
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

    public Main() {
        Vector<String> columNames = new Vector<>();
        columNames.add("index");
        columNames.add("years");
        columNames.add("weight");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Random dice = new Random();

        JTable table = new JTable(data, columNames);
        MyFrame frame = new MyFrame(table);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setSortsOnUpdates(true);//<---------------<<<<<

        for (int x = 0; x < 3; x++) {
            model.addRow(new Vector());
            for (int y = 0; y < table.getColumnCount(); y++) {
                model.setValueAt(dice.nextInt(10), x, y);
            }
        }

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < table.getColumnCount(); y++) {
                        model.setValueAt(dice.nextInt(10), x, y);
                    }
                }
            }
        });
        timer.start();
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