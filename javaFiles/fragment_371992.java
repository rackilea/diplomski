import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    private String[] colNames = { "Col 1", "Col2", "Col3", "Col4", "Col5" };

    private DefaultTableModel model;
    private JTable table;
    private MyStack myStack = new MyStack();
    private List<List<String>> list;


    public TestTable() {
        list = myStack.getList();

        model = createModel(list, colNames);
        table = new JTable(model);


        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public DefaultTableModel createModel(List<List<String>> list, String[] columnNames) {

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (List<String> row : list) {
            model.addRow(row.toArray());
        }

        return model;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestTable();
            }
        });
    }
}

class MyStack {
    public List<List<String>> list = new ArrayList<List<String>>();

    public MyStack() {
        int k = 1;
        for (int i = 0; i < 20; i++) {
            List<String> innerList= new ArrayList<String>();
            for (int j = 0; j < 5; j++) {
                innerList.add(String.valueOf( i * k * (j + 1)));
            }
            k++;
            list.add(innerList);
        }
    }

    public List<List<String>> getList() {
        return list;
    }
}