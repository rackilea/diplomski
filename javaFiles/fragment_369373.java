import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Object data[][] = { { "med1", "t1", "set1" },
                    { "med2", "t2", "set2" } };
            Object columnNames[] = { "Col1", "Col2", "Col3" };
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(model);

            frame.add(new JScrollPane(table));
            frame.setSize(300, 150);
            frame.setVisible(true);

            table.addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER
                            && table.getSelectedColumn() == table
                                    .getColumnCount() - 1
                            && table.getSelectedRow() == table.getRowCount()
                                    - 1)
                    {
                        model.addRow(new String[] { "", "", "" });
                        table.setColumnSelectionInterval(0, 0);
                    }
                }
            });
        });
    }
}