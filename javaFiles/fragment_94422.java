import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class TableDemo extends JTable {

    private static class Column {

        private int rowsCounter = 0;
        private final String identifier;

        public Column(String identifier) {
            this.identifier = identifier;
        }

        private String nextCellValue() {
            return (rowsCounter++) + ", id: " + identifier;
        }
    }

    private static class MyTableModel extends DefaultTableModel {

        private final List<Column> columns = new ArrayList<>();
        private int nextColumnIdentifier = 0;

        private void addRow() {
            Object[] row = columns.stream().map(Column::nextCellValue).toArray();
            insertRow(0, row);
        }

        private TableColumn addColumn() {
            String identifier = String.valueOf(nextColumnIdentifier++);
            columns.add(new Column(identifier));
            addColumn(identifier);
            TableColumn tc = new TableColumn();
            tc.setIdentifier(identifier);
            tc.setHeaderValue(identifier);
            tc.setModelIndex(columns.size() - 1);
            return tc;
        }

        private void removeColumn(int idx) {
            columns.remove(idx);
            columnIdentifiers.remove(idx);
            for (Object row : dataVector) {
                ((Vector<?>) row).remove(idx);
            }
            fireTableStructureChanged();
        }
    }

    private static class MyColumnsModel extends DefaultTableColumnModel {

        private TableColumn deleteColumn(int idxView) {
            if (selectionModel != null) {
                selectionModel.removeIndexInterval(idxView, idxView);
            }
            TableColumn tc = tableColumns.remove(idxView);
            tc.removePropertyChangeListener(this);
            for (TableColumn tableColumn : tableColumns) {
                if (tableColumn.getModelIndex() > tc.getModelIndex()) {
                    tableColumn.setModelIndex(tableColumn.getModelIndex() - 1);
                }
            }
            return tc;
        }
    }

    private static class HeaderMenu extends JPopupMenu {

        private int columnViewIndex;

        private HeaderMenu(final TableDemo table) {
            JMenuItem item = new JMenuItem("Delete column");
            item.addActionListener(e -> table.deleteColumn(columnViewIndex));
            add(item);

            final MouseAdapter ma = new MouseAdapter() {

                boolean dragged = false;

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (!dragged && e.getButton() == MouseEvent.BUTTON3) {
                        final Point p = e.getPoint();
                        SwingUtilities.invokeLater(() -> {
                            columnViewIndex = table.columnAtPoint(p);
                            show(e.getComponent(), p.x, p.y);
                        });
                    }
                    dragged = false;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    dragged = true;
                }
            };

            table.getTableHeader().addMouseListener(ma);
            table.getTableHeader().addMouseMotionListener(ma);
        }
    }

    private MyTableModel tableModel = new MyTableModel();
    private MyColumnsModel columnsModel = new MyColumnsModel();

    private TableDemo() {
        new HeaderMenu(this);
        setModel(tableModel);
        setColumnModel(columnsModel);
        setAutoCreateColumnsFromModel(false);
        setDefaultEditor(Object.class, null);
    }

    private void addColumn() {
        TableColumn tc = tableModel.addColumn();
        addColumn(tc); // equal to columnsModel.addColumn(tc);
    }

    private void deleteColumn(int idxView) {
        TableColumn tc = columnsModel.deleteColumn(idxView);
        tableModel.removeColumn(tc.getModelIndex());
    }

    private static void buildAndShowGui() {
        TableDemo table = new TableDemo();
        table.setPreferredScrollableViewportSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        JButton buttonAdd = new JButton("Add column");
        buttonAdd.addActionListener(e -> table.addColumn());
        int gaps = 10;
        JPanel panel = new JPanel(new BorderLayout(gaps, gaps));
        panel.setBorder(BorderFactory.createEmptyBorder(gaps, gaps, gaps, gaps));
        panel.add(buttonAdd, BorderLayout.NORTH);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        JFrame frame = new JFrame(table.getClass().getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> table.tableModel.addRow());
            }
        }, 500, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> buildAndShowGui());
    }
}