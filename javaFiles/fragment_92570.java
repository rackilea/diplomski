import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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

                DefaultListModel<Item> itemListModel = new DefaultListModel<>();
                itemListModel.addElement(new Item("A", false));
                itemListModel.addElement(new Item("B", true));
                itemListModel.addElement(new Item("C", false));
                itemListModel.addElement(new Item("D", false));
                itemListModel.addElement(new Item("E", true));
                itemListModel.addElement(new Item("F", true));
                itemListModel.addElement(new Item("G", false));
                itemListModel.addElement(new Item("H", true));

                JList list = new JList(itemListModel);
                list.setCellRenderer(new CheckBoxListCellRenderer());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(list));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Item {

        public String itemName;
        public boolean checked;

        public Item(String itemName, boolean checked) {
            this.itemName = itemName;
            this.checked = checked;
        }

        public boolean isChecked() {
            return checked;
        }

        public String getItemName() {
            return itemName;
        }

        @Override
        public String toString() {
            return itemName;
        }
    }

    public static class CheckBoxListCellRenderer extends JCheckBox implements ListCellRenderer<Item> {

        private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

        public CheckBoxListCellRenderer() {
            setOpaque(false);
            setBorder(DEFAULT_NO_FOCUS_BORDER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {
            setSelected(value.isChecked());
            setText(value.getItemName());
            Color fg = list.getForeground();
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                fg = list.getSelectionForeground();
            } else {
                setBackground(list.getBackground());
            }
            setForeground(fg);
            setOpaque(isSelected);
            Border border = null;
            if (cellHasFocus) {
                if (isSelected) {
                    border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
                }
                if (border == null) {
                    border = UIManager.getBorder("List.focusCellHighlightBorder");
                }
            } else {
                border = DEFAULT_NO_FOCUS_BORDER;
            }
            setBorder(border);
            return this;
        }

    }

}