import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableFilter {

    public static void main(String[] args) {
        new TableFilter();
    }

    private JTable table;
    private JComboBox filterBy;
    private JTextField filterText;

    public TableFilter() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(new Object[]{"Code", "Description"}, 0);
                model.addRow(new Object[]{"A001", "Holidays"});
                model.addRow(new Object[]{"B001", "Sick"});
                model.addRow(new Object[]{"A002", "Zombitse"});
                model.addRow(new Object[]{"C001", "Crazy bin"});
                model.addRow(new Object[]{"C002", "Postal"});
                model.addRow(new Object[]{"D002", "Job Interview"});
                model.addRow(new Object[]{"D004", "it's sunny outside"});

                table = new JTable(model);
                table.setRowSorter(new TableRowSorter<TableModel>(model));

                JPanel filterPane = new JPanel(new GridBagLayout());
                filterBy = new JComboBox(new Object[]{"Nothing", "Code", "Description"});
                filterText = new JTextField(20);
                filterPane.add(filterBy);
                filterPane.add(filterText);

                filterBy.setSelectedIndex(0);
                filterBy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateFilter();
                    }
                });

                filterText.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateFilter();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateFilter();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateFilter();
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(filterPane, BorderLayout.NORTH);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected void updateFilter() {
        Object selected = filterBy.getSelectedItem();
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) table.getRowSorter();
        String text = "(?i)" + filterText.getText();
        if ("Nothing".equals(selected)) {
            sorter.setRowFilter(null);
        } else {
            int col = -1;
            if ("Code".equals(selected)) {
                col = 0;
            } else if ("Description".equals(selected)) {
                col = 1;
            }
            sorter.setRowFilter(RowFilter.regexFilter(text, col));
        }
    }

}