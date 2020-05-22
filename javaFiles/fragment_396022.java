import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableCellProgressBar {

    private String[] columnNames = {"String", "ProgressBar"};
    private Object[][] data = {{"dummy", 100}};
    private DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        private static final long serialVersionUID = 1L;

        @Override
        public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    private JTable table = new JTable(model);

    public JComponent makeUI() {
        TableColumn column = table.getColumnModel().getColumn(1);
        column.setCellRenderer(new ProgressRenderer());
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                startTask("test");
                startTask("error test");
                startTask("test");
            }
        });
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(table));
        return p;
    }
//http://java-swing-tips.blogspot.com/2008/03/jprogressbar-in-jtable-cell.html

    private void startTask(String str) {
        final int key = model.getRowCount();
        SwingWorker<Integer, Integer> worker = new SwingWorker<Integer, Integer>() {

            private int sleepDummy = new Random().nextInt(100) + 1;
            private int lengthOfTask = 120;

            @Override
            protected Integer doInBackground() {
                int current = 0;
                while (current < lengthOfTask && !isCancelled()) {
                    if (!table.isDisplayable()) {
                        break;
                    }
                    if (key == 2 && current > 60) { //Error Test
                        cancel(true);
                        publish(-1);
                        return -1;
                    }
                    current++;
                    try {
                        Thread.sleep(sleepDummy);
                    } catch (InterruptedException ie) {
                        break;
                    }
                    publish(100 * current / lengthOfTask);
                }
                return sleepDummy * lengthOfTask;
            }

            @Override
            protected void process(java.util.List<Integer> c) {
                model.setValueAt(c.get(c.size() - 1), key, 1);
            }

            @Override
            protected void done() {
                String text;
                int i = -1;
                if (isCancelled()) {
                    text = "Cancelled";
                } else {
                    try {
                        i = get();
                        text = (i >= 0) ? "Done" : "Disposed";
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                        text = ignore.getMessage();
                    }
                }
                System.out.println(key + ":" + text + "(" + i + "ms)");
            }
        };
        model.addRow(new Object[]{str, 0});
        worker.execute();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TableCellProgressBar().makeUI());
        frame.setSize(320, 240);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class ProgressRenderer extends DefaultTableCellRenderer {

    private final JProgressBar b = new JProgressBar(0, 100);

    public ProgressRenderer() {
        super();
        setOpaque(true);
        b.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Integer i = (Integer) value;
        String text = "Completed";
        if (i < 0) {
            text = "Error";
        } else if (i < 100) {
            b.setValue(i);
            return b;
        }
        super.getTableCellRendererComponent(table, text, isSelected, hasFocus, row, column);
        return this;
    }
}