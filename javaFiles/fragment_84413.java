import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class CreateRowGui extends JPanel {
    private static final Item[] ITEMS = { 
            new Item("Light Bulb", 2.00), 
            new Item("Toilet Paper", 3.00),
            new Item("Toothpaste", 1.50), 
            new Item("Aspirin", 3.75) };
    private ItemTableModel tableModel = new ItemTableModel();
    private JTable table = new JTable(tableModel);
    private AddRowAction addRowAction = new AddRowAction("Add Row", KeyEvent.VK_A);

    public CreateRowGui() {
        TableCellRenderer moneyRenderer = new DefaultTableCellRenderer() {
            private NumberFormat currFormat = NumberFormat.getCurrencyInstance();

            @Override
            protected void setValue(Object value) {
                if (value != null) {
                    value = currFormat.format(value);
                }
                super.setValue(value);
            }
        };
        table.getColumnModel().getColumn(2).setCellRenderer(moneyRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(moneyRenderer);

        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton(addRowAction));
        btnPanel.add(new JButton("Remove Row")); // TODO: need Action for this

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
        add(btnPanel, BorderLayout.PAGE_END);
    }

    class AddRowAction extends AbstractAction {
        private NewRowPanel newRowPanel = new NewRowPanel(ITEMS);

        public AddRowAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            newRowPanel.reset();
            int reply = JOptionPane.showConfirmDialog(table, 
                    newRowPanel.getMainPanel(), 
                    "Select Item and Quantity",
                    JOptionPane.OK_CANCEL_OPTION, 
                    JOptionPane.PLAIN_MESSAGE);
            if (reply == JOptionPane.OK_OPTION) {
                Item item = newRowPanel.getSelectedItem();
                int quantity = newRowPanel.getQuantity();
                tableModel.addRow(item, quantity);
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("CreateRowGui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CreateRowGui());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class NewRowPanel {
    private JPanel mainPanel = new JPanel();
    private JComboBox<Item> itemsCombo;
    private JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));

    @SuppressWarnings("serial")
    public NewRowPanel(Item[] items) {
        itemsCombo = new JComboBox<>(items);
        itemsCombo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value != null) {
                    value = ((Item) value).getName();
                } else {
                    value = "";
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        mainPanel.add(new JLabel("Item:"));
        mainPanel.add(itemsCombo);
        mainPanel.add(Box.createHorizontalStrut(15));
        mainPanel.add(new JLabel("Quantity"));
        mainPanel.add(quantitySpinner);
    }

    public void reset() {
        itemsCombo.setSelectedIndex(-1);
        quantitySpinner.setValue(0);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Item getSelectedItem() {
        return (Item) itemsCombo.getSelectedItem();
    }

    public int getQuantity() {
        return (int) quantitySpinner.getValue();
    }
}

class ItemTableModel extends AbstractTableModel {
    private static final String[] COL_NAMES = { "Item Name", "Quantity", "Unit Price", "Total" };
    private static final long serialVersionUID = 1L;
    private List<ItemWithCount> itemsWithCount = new ArrayList<>();

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return itemsWithCount.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return super.getColumnClass(columnIndex);
        case 1:
            return Integer.class;
        case 2:
        case 3:
            return Double.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return COL_NAMES[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        ItemWithCount itemWithCount = itemsWithCount.get(row);
        switch (column) {
        case 0:
            return itemWithCount.getItem().getName();
        case 1:
            return itemWithCount.getCount();
        case 2:
            return itemWithCount.getItem().getUnitPrice();
        case 3:
            return itemWithCount.getCount() * itemWithCount.getItem().getUnitPrice();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ItemWithCount itemWithCount = itemsWithCount.get(rowIndex);
        switch (columnIndex) {
        case 1:
            itemWithCount.setCount((int) aValue);
            fireTableRowsUpdated(rowIndex, rowIndex);
            break;

        default:
            break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 0 || columnIndex == 1;
    }

    public void addRow(Item item, int quantity) {
        ItemWithCount itemWithCount = new ItemWithCount(item, quantity);
        itemsWithCount.add(itemWithCount);
        int row = itemsWithCount.size() - 1;
        fireTableRowsInserted(row, row);
    }

    private class ItemWithCount {
        private Item item;
        private int count;

        public ItemWithCount(Item item, int count) {
            this.item = item;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Item getItem() {
            return item;
        }

    }
}

class Item {
    private String name;
    private double unitPrice;

    public Item(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", unitPrice=" + unitPrice + "]";
    }

}