import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.WeakHashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TestSearchTable {

    public static void main(String[] args) {
        new TestSearchTable();
    }

    public TestSearchTable() {
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

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());

            DefaultTableModel model = new DefaultTableModel(
                            new Object[][]{
                                {"Tiana", "Wilmer"},
                                {"Twana", "Wingate"},
                                {"Cody", "Baumgarten"},
                                {"Venus", "Espy"},
                                {"Savanna", "Buckmaster"},
                                {"Adrien", "Edgecomb"},
                                {"Lauretta", "Sassman"},
                                {"Vivienne", "Glasco"},
                                {"Cassy", "Merryman"},
                                {"Mitchel", "Jarvie"},
                                {"Kelsi", "Casebeer"},
                                {"Rosy", "Rizzi"},
                                {"Bernice", "Capote"},
                                {"Tijuana", "Launius"},
                                {"Jeffie", "Crownover"},
                                {"Selena", "Leavy"},
                                {"Damon", "Tulloch"},
                                {"Norris", "Devitt"},
                                {"Cecil", "Burgio"},
                                {"Queen", "Mechling"}},
                            new Object[]{"First Name", "Last name"}
            ) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };

            JTable table = new JTable(model);
            table.setAutoCreateRowSorter(true);
            TableUtilities.installFilterSupport(table,
                            new TableUtilities.IFilterListener() {
                                @Override
                                public void filterChanged(JTable table, String filter) {
                                    TableRowSorter sorter = (TableRowSorter) table.getRowSorter();
                                    if (filter == null || filter.trim().length() == 0) {
                                        filter = "*";
                                    }

                                    if (!filter.startsWith("*") || !filter.endsWith("*")) {
                                        filter = "*" + filter + "*";
                                    }
                                    filter = wildcardToRegex(filter);
                                    filter = "(?i)" + filter;
                                    sorter.setRowFilter(RowFilter.regexFilter(filter));
                                }

                                @Override
                                public void filterCancelled(JTable table, TableUtilities.IFilterSupport support) {
//                                  support.setFilter(null);
                                }
                            },
                            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
            add(new JScrollPane(table));
        }

    }

    public static String wildcardToRegex(String wildcard) {

        StringBuilder s = new StringBuilder(wildcard.length());
        s.append('^');

        for (int i = 0, is = wildcard.length(); i < is; i++) {

            char c = wildcard.charAt(i);
            switch (c) {
                case '*':
                    s.append(".*");
                    break;
                case '?':
                    s.append(".");
                    break;
                // escape special regexp-characters
                case '(':
                case ')':
                case '[':
                case ']':
                case '$':
                case '^':
                case '.':
                case '{':
                case '}':
                case '|':
                case '\\':
                    s.append("\\");
                    s.append(c);
                    break;
                default:
                    s.append(c);
                    break;
            }

        }

        s.append('$');
        return (s.toString());

    }

}