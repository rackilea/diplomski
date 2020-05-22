import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
            JTable table = new JTable(new DefaultTableModel(5, 5));
            setLayout(new GridBagLayout());
            setBorder(new EmptyBorder(20, 20, 20, 20));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new JScrollPane(table), gbc);
            add(new JTextField(10), gbc);

            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof FocusEvent) {
                        FocusEvent focusEvent = (FocusEvent) event;
                        if (focusEvent.getID() == FocusEvent.FOCUS_LOST) {
                            Component focusTo = focusEvent.getOppositeComponent();
                            Component focusFrom = focusEvent.getComponent();

                            JTable table = getTableFrom(focusFrom);
                            if (focusTo == null || !focusTo.getParent().equals(table)) {

                                stopCellEditing(table);
                                clearSelection(table);

                            }
                        }
                    } else if (event instanceof MouseEvent) {
                        MouseEvent mouseEvent = (MouseEvent) event;
                        if (mouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
                            Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                            JTable table = getTableFrom(focusOwner);
                            System.out.println("     table = " + table);
                            System.out.println("focusOwner = " + focusOwner);
//                          if ((table != null && mouseEvent.getComponent() != table) || (focusOwner != null && !focusOwner.getParent().equals(table))) {
                            if ((table != null && mouseEvent.getComponent() != table) && (focusOwner != null && !focusOwner.getParent().equals(table))) {
                                stopCellEditing(table);
                                clearSelection(table);
                            }
                        }
                    }
                }

                protected JTable getTableFrom(Component component) {
                    JTable table = null;
                    if (component instanceof JTable) {
                        table = (JTable) component;
                    } else if (component != null && component.getParent() instanceof JTable) {
                        table = (JTable) component.getParent();
                    }
                    return table;
                }

                protected void clearSelection(JTable table) {
                    if (table != null) {
                        table.clearSelection();
                    }
                }

                protected void stopCellEditing(JTable table) {

                    if (table != null) {
                        TableCellEditor cellEditor = table.getCellEditor();
                        if (cellEditor != null) {
                            if (!cellEditor.stopCellEditing()) {
                                cellEditor.cancelCellEditing();
                            }
                        }
                    }
                }
            }, AWTEvent.FOCUS_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
        }

    }

}