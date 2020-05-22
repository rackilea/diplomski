import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

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

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());

            JTable table = new JTable(new DefaultTableModel(10, 10));

            JTextField editorField = new JTextField(10);
            editorField.setBorder(new EmptyBorder(1, 1, 1, 1));
            editorField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    TableCellEditor cellEditor = table.getCellEditor();
                    if (cellEditor != null) {
                        if (!cellEditor.stopCellEditing()) {
                            cellEditor.cancelCellEditing();
                        }
                    }

                    Component gotFocus = e.getOppositeComponent();
                    if (!gotFocus.equals(table)) {
                        table.clearSelection();
                    }
                }
            });
            DefaultCellEditor editor = new DefaultCellEditor(editorField);
            table.setDefaultEditor(Object.class, editor);

            add(new JScrollPane(table));
            table.addFocusListener(new FocusAdapter() {

                @Override
                public void focusLost(FocusEvent e) {
                    Component gotFocus = e.getOppositeComponent();
                    if (!gotFocus.getParent().equals(table)) {
                        TableCellEditor cellEditor = table.getCellEditor();
                        if (cellEditor != null) {
                            if (!cellEditor.stopCellEditing()) {
                                cellEditor.cancelCellEditing();
                            }
                        }
                        table.clearSelection();
                    }
                }

            });

            JTextField field = new JTextField(10);
            add(field, BorderLayout.SOUTH);
        }

    }

}