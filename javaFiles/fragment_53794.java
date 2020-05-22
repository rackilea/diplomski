import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddItems extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 450;
    private JTextField inputField = new JTextField(20);
    private AddToTableAction addAction = new AddToTableAction("Add");
    private JButton addButton = new JButton(addAction);
    private DefaultTableModel tableModel = new DefaultTableModel(new String[]{"A"}, 0);
    private JTable table = new JTable(tableModel){
        public boolean isCellEditable(int row, int column) {
            return false;
        };
    };

    public AddItems() {
        table.setTableHeader(null);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        inputField.setAction(addAction);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        topPanel.add(inputField);
        topPanel.add(addButton);

        setLayout(new BorderLayout());
        add(scrollPane);
        add(topPanel, BorderLayout.PAGE_START);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension prefSize = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return prefSize;
        } else {
            int w = Math.max(PREF_W, prefSize.width);
            int h = Math.max(PREF_H, prefSize.height);
            return new Dimension(w, h);
        }
    }

    private class AddToTableAction extends AbstractAction {
        public AddToTableAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputField.getText();
            tableModel.addRow(new String[] {text});
            inputField.selectAll();
            inputField.requestFocusInWindow();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        AddItems mainPanel = new AddItems();
        JFrame frame = new JFrame("AddItems");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}