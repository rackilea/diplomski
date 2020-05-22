import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableRowHeight {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame("p*s*s*s*s*t*t");
    private String[] columnNames = {"one", "two", "Playing with", "four", "five",};
    private String[][] data = {
        {"aaaaaa", "bbbbbb", "cccccc", "dddddd", "eeeeeee",},
        {"bbbbbb", "cccccc", "dddddd", "eeeeeee", "aaaaaa",},
        {"cccccc", "dddddd", "eeeeeee", "aaaaaa", "bbbbbb",},
        {"dddddd", "eeeeeee", "aaaaaa", "bbbbbb", "cccccc",},
        {"eeeeeee", "aaaaaa", "bbbbbb", "cccccc", "dddddd",}};
    private JTable table = new JTable(new DefaultTableModel(data, columnNames));
    private TableColumnModel tcm = table.getColumnModel();
    private Stack<TableColumn> colDeleted = new Stack<TableColumn>();
    private JButton restoreButton = new JButton("Restore Column Size");
    private JButton hideButton = new JButton("Set Column Size to Zero");
    private JButton deleteButton = new JButton("Delete Column");
    private JButton addButton = new JButton("Restore Column");

    public TableRowHeight() {
        table.setRowMargin(4);
        table.setRowHeight(30);
        table.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(table);
        for (int i = 0; i < (tcm.getColumnCount()); i++) {
            tcm.getColumn(i).setPreferredWidth(100);
        }
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        restoreButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tcm.getColumn(2).setPreferredWidth(100);
            }
        });
        hideButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tcm.getColumn(2).setPreferredWidth(000);
            }
        });
        deleteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (table.getColumnCount() > 0) {
                    TableColumn colToDelete = table.getColumnModel().getColumn(table.getColumnCount() - 1);
                    table.removeColumn(colToDelete);
                    table.validate();
                    colDeleted.push(colToDelete);
                    addButton.setEnabled(true);
                } else {
                    deleteButton.setEnabled(false);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (colDeleted.size() > 0) {
                    table.addColumn(colDeleted.pop());
                    table.validate();
                    deleteButton.setEnabled(true);
                } else {
                    addButton.setEnabled(false);
                }
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(hideButton);
        btnPanel.add(restoreButton);
        btnPanel.add(deleteButton);
        btnPanel.add(addButton);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                TableRowHeight frame = new TableRowHeight();
            }
        });
    }
}