import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableTimeChange {

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:dd:ss");
    private JTable table = new JTable(getTableModel());

    public TableTimeChange() {
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        Timer timer = new Timer(1000, new TimerListener());
        timer.start();
        frame.setVisible(true);
    }

    private TableModel getTableModel() {
        String[] cols = {"Time", "Is Seconds Even"};
        Object[][] data = { { getNewRow() }, { getNewRow() } };
        DefaultTableModel model = new DefaultTableModel(data, cols);
        return model;
    }

    private String getFormatDate(Date date) {
        return format.format(date);
    }

    private Object[] getNewRow() {
        Calendar cal = Calendar.getInstance();
        int seconds = cal.get(Calendar.SECOND);
        boolean isSecondsEven = (seconds % 2 == 0);
        return new Object[] { getFormatDate(cal.getTime()), isSecondsEven };
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            for (int i = model.getRowCount() -1; i >= 0; i--) {
                Object[] row = getNewRow();
                model.setValueAt(row[0], i, 0);
                model.setValueAt(row[1], i, 1);
            }   
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableTimeChange();
            }
        });
    }
}