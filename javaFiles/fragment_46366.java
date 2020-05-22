import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TestTableRenderer {

    public static void main(String[] args) {
        new TestTableRenderer();
    }

    public TestTableRenderer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            TableModel model = new AbstractTableModel() {

                @Override
                public int getRowCount() {
                    return 2;
                }

                @Override
                public int getColumnCount() {
                    return 1;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    return rowIndex == 0 ? true : false;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return Boolean.class;
                }

            };
            JTable table = new JTable(model);
            table.setDefaultRenderer(Boolean.class, new CustomBooleanCellRenderer());
            setLayout(new BorderLayout());
            add(new JScrollPane(table));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class CustomBooleanCellRenderer extends JCheckBox implements TableCellRenderer {

        private ImageIcon sad;
        private ImageIcon happy;

        public CustomBooleanCellRenderer() {
            try {
                happy = new ImageIcon(ImageIO.read(getClass().getResource("/Happy.png")));
                sad = new ImageIcon(ImageIO.read(getClass().getResource("/Sad.png")));
            } catch (IOException ex) {
                Logger.getLogger(TestTableRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void setSelected(boolean selected) {
            super.setSelected(selected); 
            if (selected) {
                setIcon(happy);
            } else {
                setIcon(sad);
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                boolean selected = (boolean) value;
                setSelected(selected);
            }
            return this;
        }
    }
}