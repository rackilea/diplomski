import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.*;
import javax.swing.table.*;

public class TestTableRowTable {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (info.getName().equals("Nimbus")) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                final JTable table = new JTable(10, 6);
                for (int i = 0; i < table.getRowCount(); i++) {
                    table.setValueAt(i, i, 0);
                }
                final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
                table.setRowSorter(sorter);
                final AbstractTableModel model = new AbstractTableModel() {

                    private static final long serialVersionUID = 1L;

                    @Override
                    public int getColumnCount() {
                        return 1;
                    }

                    @Override
                    public Object getValueAt(int row, int column) {
                        return table.convertRowIndexToModel(row);
                    }

                    @Override
                    public int getRowCount() {
                        return table.getRowCount();
                    }
                };
                JTable headerTable = new JTable(model);
                headerTable.setShowGrid(false);
                headerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                headerTable.setPreferredScrollableViewportSize(new Dimension(30, 0));
                headerTable.getColumnModel().getColumn(0).setPreferredWidth(30);
                headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

                    @Override
                    public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                        boolean selected = table.getSelectionModel().isSelectedIndex(row);
                        Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, false, false, -1, -2);
                        ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);
                        if (selected) {
                            component.setFont(component.getFont().deriveFont(Font.BOLD));
                        } else {
                            component.setFont(component.getFont().deriveFont(Font.PLAIN));
                        }
                        return component;
                    }
                });
                table.getRowSorter().addRowSorterListener(
                        new RowSorterListener() {

                            @Override
                            public void sorterChanged(RowSorterEvent e) {
                                model.fireTableDataChanged();
                            }
                        });
                table.getSelectionModel().addListSelectionListener(
                        new ListSelectionListener() {

                            @Override
                            public void valueChanged(ListSelectionEvent e) {
                                model.fireTableRowsUpdated(0, model.getRowCount() - 1);
                            }
                        });
                JScrollPane pane = new JScrollPane(table);
                pane.setRowHeaderView(headerTable);
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(pane);
                frame.getContentPane().add(new JButton(new AbstractAction("Toggle filter") {

                    private static final long serialVersionUID = 1L;
                    private RowFilter<TableModel, Object> filter = new RowFilter<TableModel, Object>() {

                        @Override
                        public boolean include(javax.swing.RowFilter.Entry<? extends TableModel, ? extends Object> entry) {
                            return ((Number) entry.getValue(0)).intValue() % 2 == 0;
                            //return ((String) entry.getValue(0)).length()>0 ;
                            //return ((Date) entry.getValue(0)).getTime()< ;
                        }
                    };

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (sorter.getRowFilter() != null) {
                            sorter.setRowFilter(null);
                        } else {
                            sorter.setRowFilter(filter);
                        }
                    }
                }), BorderLayout.PAGE_END);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private TestTableRowTable() {
    }
}