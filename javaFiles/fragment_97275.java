import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class TestTableKeyBinding extends JFrame {

    private static final int MASK =
        Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TestTableKeyBinding test = new TestTableKeyBinding();
                test.setVisible(true);
            }
        });
    }

    TestTableKeyBinding() {
        super();
        initUI();
        addKeyBindings();
    }

    private void initUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] headers = new String[]{"apples", "bananas"};
        String[][] data = new String[][]{{"1", "2"}, {"4", "6"}};
        table = new JTable(data, headers);
        table.setCellSelectionEnabled(true);
        this.add(new JScrollPane(table));
        this.pack();
        this.setSize(new Dimension(300, 400));

    }

    private void addKeyBindings() {
        //root maps
        InputMap im = this.getRootPane().getInputMap(
            JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = this.getRootPane().getActionMap();
        //add custom action
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, MASK), "save");
        am.put("save", saveAction());
    }

    private AbstractAction saveAction() {
        AbstractAction save = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    TestTableKeyBinding.this.table, "Action Triggered.");
                table.editingCanceled(null);
            }
        };
        return save;
    }
}