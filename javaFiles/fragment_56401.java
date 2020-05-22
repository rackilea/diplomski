import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Vector;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Cell {

        private boolean isBooked;

        public Cell() {
            isBooked = Math.random() > 0.5 ? true : false;
        }

        public boolean isBooked() {
            return isBooked;
        }
    }

    public static class CellTableCellRenderer extends DefaultTableCellRenderer {

        private static Color BOOKED_COLOR = Color.DARK_GRAY;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Cell) {
                Cell cell = (Cell) value;
                if (cell.isBooked) {
                    setBackground(BOOKED_COLOR);
                } else if (isSelected) {
                    setBackground(table.getSelectionBackground());
                } else {
                    setBackground(table.getBackground());
                }
            }
            return this;
        }

    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());

            DefaultTableModel model = new DefaultTableModel(0, 10) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return Cell.class;
                }

            };
            for (int row = 0; row < 10; row++) {
                Vector<Cell> cells = new Vector<>(10);
                for (int col = 0; col < 10; col++) {
                    cells.add(new Cell());
                }
                model.addRow(cells);
            }

            JTable table = new JTable(model);
            table.setDefaultRenderer(Cell.class, new CellTableCellRenderer());
            add(new JScrollPane(table));
        }

    }

    public class RowSelectionModel extends DefaultListSelectionModel {

        @Override
        public void setSelectionInterval(int index0, int index1) {
            System.out.println("Row-setSelectionInterval-" + index0 + "-" + index1);
            super.setSelectionInterval(index0, index1); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public class ColumnSelectionModel extends DefaultListSelectionModel {

        @Override
        public void setSelectionInterval(int index0, int index1) {
            System.out.println("Column-setSelectionInterval-" + index0 + "-" + index1);
            super.setSelectionInterval(index0, index1); //To change body of generated methods, choose Tools | Templates.
        }
    }
}