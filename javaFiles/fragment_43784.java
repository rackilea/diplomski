import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Tables {

    private static class JScrollPaneExtension extends JScrollPane implements TableModelListener, AdjustmentListener {
        private boolean frozen = false;
        private Vector<String> rowData;
        private final JTable table;
        private final MyTableModel tableModel;

        private JScrollPaneExtension(JTable table, MyTableModel tableModel) {
            super(table);
            this.table = table;
            this.tableModel = tableModel;
            tableModel.addTableModelListener(this);
            getVerticalScrollBar().addAdjustmentListener(this);
        }

        public boolean isFrozen() {
            return frozen;
        }

        public void setFrozen(boolean frozen) {
            if (frozen != this.frozen) {
                this.frozen = frozen;
                if (frozen) {
                    captureCurrentTopRowData();
                } else {
                    rowData = null;
                }
            }
        }

        private void captureCurrentTopRowData() {
            int row = table.rowAtPoint(getViewport().getViewPosition());
            if (row > -1) {
                rowData = (Vector<String>) tableModel.getDataVector().get(row);
            }
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            if (frozen) {
                captureCurrentTopRowData();
                scrollToRowData();
            }
        }

        @Override
        public void tableChanged(TableModelEvent e) {
            scrollToRowData();
        }

        private void scrollToRowData() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (frozen) {
                        int index = tableModel.getDataVector().indexOf(rowData);
                        getViewport().setViewPosition(table.getCellRect(index, 0, true).getLocation());
                    }
                }
            });
        }

    }

    public static class MyTableModel extends DefaultTableModel {
        private int count;

        private boolean frozen = false;

        private List<Vector<String>> buffer = new ArrayList<Vector<String>>();

        public MyTableModel() {
            addColumn("Test");
        }

        public void insertNewRow() {
            Vector<String> rowData = createNewRowData();
            if (isFrozen()) {
                buffer.add(rowData);
            } else {
                insertRow(0, rowData);
            }
        }

        private Vector<String> createNewRowData() {
            Vector<String> data = new Vector<String>(1);
            data.add("Hello-" + (count++));
            return data;
        }

        public boolean isFrozen() {
            return frozen;
        }

        public void setFrozen(boolean frozen) {
            if (frozen == this.frozen) {
                return;
            }
            this.frozen = frozen;
            if (!frozen) {
                flushBuffer();
            }
        }

        private void flushBuffer() {
            for (Vector<String> rowData : buffer) {
                insertRow(0, rowData);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final MyTableModel model = new MyTableModel();
        JTable table = new JTable(model);
        final JScrollPaneExtension scroll = new JScrollPaneExtension(table, model);
        JPanel panel = new JPanel();
        final JButton freeze = new JButton("Freeze");
        freeze.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (model.isFrozen()) {
                    freeze.setText("Freeze model");
                } else {
                    freeze.setText("Continue");
                }
                model.setFrozen(!model.isFrozen());
            }
        });
        final JButton freeze2 = new JButton("Freeze scroll");
        freeze2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (scroll.isFrozen()) {
                    freeze2.setText("Freeze scroll");
                } else {
                    freeze2.setText("Resume scroll");
                }
                scroll.setFrozen(!scroll.isFrozen());
            }
        });
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll);
        panel.add(freeze);
        panel.add(freeze2);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        model.insertNewRow();
                    }
                });
            }
        }, new Date(), 300);
    }
}