import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter.SortKey;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MyFrame {

    private JFrame frame = new JFrame();
    private JTable table;
    private JPanel buttonPanel = new JPanel();
    private JPanel buttonPanelSouth = new JPanel();
    private JPanel textFieldPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JLabel l1, l2, l3, l4;
    private JTextField tf1, tf2, tf3, tf4;
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private String[] columnNames = {"Nama", "Nim", "IP", "Hapus Baris ke"};
    private Object[][] data = {
        {"igor", "B01_125-358", "1.124.01.125", true},
        {"lenka", "B21_002-242", "21.124.01.002", true},
        {"peter", "B99_001-358", "99.124.01.001", false},
        {"zuza", "B12_100-242", "12.124.01.100", true},
        {"jozo", "BUS_011-358", "99.124.01.011", false},
        {"nora", "B09_154-358", "9.124.01.154", false},
        {"xantipa", "B01_001-358", "1.124.01.001", false},};
    private DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            switch (column) {
                case 3:
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };

    public MyFrame() {
        table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        table.getSelectionModel().setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);
        DefaultTableCellRenderer stringRenderer =
                (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane pane = new JScrollPane(table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        centerPanel.setLayout(new BorderLayout(10, 10));
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.add(pane);
        centerPanel.add(pane);
//        
        b1 = new JButton("add Row");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{(tf1.getText()).trim(),
                            (tf2.getText()).trim(), (tf3.getText()).trim(), true});
            }
        });
        b2 = new JButton("Delete Row");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowToDelete = 0;
                int rowToModel = 0;
                if (table.getSelectedRow() > -1) {
                    rowToDelete = table.getSelectedRow();
                    rowToModel = table.convertRowIndexToModel(rowToDelete);
                    model.removeRow(rowToModel);
                }
            }
        });
        b3 = new JButton("RESET");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.getRowSorter().setSortKeys(null);
            }
        });
        b4 = new JButton("SortName");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.getRowSorter().toggleSortOrder(0);
            }
        });
        b5 = new JButton("SortNim");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter rowSorter = (TableRowSorter) table.getRowSorter();
                List<SortKey> sortKeys = new ArrayList<SortKey>();
                SortKey sortKey = new SortKey(1, SortOrder.ASCENDING);
                sortKeys.add(sortKey);
                rowSorter.setSortKeys(sortKeys);
                rowSorter.sort();
            }
        });
        b6 = new JButton("SortIP");
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter rowSorter = (TableRowSorter) table.getRowSorter();
                List<SortKey> sortKeys = new ArrayList<SortKey>();
                SortKey sortKey = new SortKey(2, SortOrder.DESCENDING);
                sortKeys.add(sortKey);
                SortKey sortKey1 = new SortKey(1, SortOrder.ASCENDING);
                sortKeys.add(sortKey1);
                SortKey sortKey2 = new SortKey(0, SortOrder.UNSORTED);
                sortKeys.add(sortKey2);
                rowSorter.setSortKeys(sortKeys);
                rowSorter.sort();
            }
        });
        b7 = new JButton("SortIP");
        buttonPanel.setLayout(new GridLayout(1, 0, 50, 0));
        buttonPanel.setBorder(new EmptyBorder(2, 10, 2, 10));
        buttonPanel.add(b1);
        buttonPanel.add(b2);
//
        buttonPanelSouth.setLayout(new GridLayout(1, 4, 5, 5));
        buttonPanelSouth.add(b3);
        buttonPanelSouth.add(b7);
        b7.setVisible(false);
        buttonPanelSouth.add(b4);
        buttonPanelSouth.add(b5);
        buttonPanelSouth.add(b6);
        centerPanel.add(buttonPanelSouth, BorderLayout.SOUTH);

//
        l1 = new JLabel("Nama : ", JLabel.RIGHT);
        tf1 = new JTextField();
        l2 = new JLabel("Nim  : ", JLabel.RIGHT);
        tf2 = new JTextField();
        l3 = new JLabel("IPK : ", JLabel.RIGHT);
        tf3 = new JTextField();
        l4 = new JLabel("Hapus Baris ke :", JLabel.RIGHT);
        tf4 = new JTextField();
        textFieldPanel.setLayout(new GridLayout(4, 2, 10, 10));
        textFieldPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        textFieldPanel.add(l1);
        textFieldPanel.add(tf1);
        textFieldPanel.add(l2);
        textFieldPanel.add(tf2);
        textFieldPanel.add(l3);
        textFieldPanel.add(tf3);
        textFieldPanel.add(l4);
        textFieldPanel.add(tf4);
//
        northPanel.setLayout(new BorderLayout());
        northPanel.add(textFieldPanel);
        northPanel.add(buttonPanel, BorderLayout.SOUTH);
//
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] arg) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame myFrame = new MyFrame();
            }
        });
    }
}