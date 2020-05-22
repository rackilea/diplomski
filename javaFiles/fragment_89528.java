import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TestFrame extends JFrame {

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        JTable t = new JTable(3,3);
        t.getColumnModel().getColumn(0).setCellRenderer(getRenderer());
        add(new JScrollPane(t));
    }

    private TableCellRenderer getRenderer() {
        return new DefaultTableCellRenderer(){

            private JLabel l = new JLabel();
            {
                l.setOpaque(true);
            }

            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JComponent tableCellRendererComponent = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                l.setText(value == null ? "" : value.toString());
                l.setBorder(tableCellRendererComponent.getBorder());
                l.setBackground(tableCellRendererComponent.getBackground());
                l.setForeground(tableCellRendererComponent.getForeground());
                return l;
            }
        };
    }

    public static void main(String... s){
        new TestFrame();
    }

}