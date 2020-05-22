import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(new String[]{"Fruit"}, 0);
                model.addRow(new String[]{"Banana"});
                model.addRow(new String[]{""});
                model.addRow(new String[]{"Apple"});
                model.addRow(new String[]{""});
                model.addRow(new String[]{"Strewberry"});
                model.addRow(new String[]{""});
                model.addRow(new String[]{"Grape"});
                model.addRow(new String[]{""});

                JTable table = new JTable(model);
                table.setAutoCreateRowSorter(true);
                TableRowSorter sorter = (TableRowSorter) table.getRowSorter();
                sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        boolean included = true;
                        Object cellValue = entry.getModel().getValueAt(entry.getIdentifier(), 0);
                        if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                            included = false;
                        }
                        return included;
                    }
                });


                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}