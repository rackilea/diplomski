import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JSplitPaneToy {

    public static void main(String[] args) {
        UIManager.getDefaults().put("SplitPane.border", BorderFactory.createEmptyBorder());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JSplitPaneToy().initUI();
            }
        });
    }

    public void initUI() {
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, makePanel(), makePanel());
        sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, makePanel(), sp);
        sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, makePanel(), sp);
        sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, makePanel(), sp);

        JFrame frame = new JFrame("JSplitPane Toy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(sp);
        frame.pack();
        frame.setVisible(true);
    }

    private JScrollPane makePanel() {
        JScrollPane pane = new JScrollPane(new JTable(new Object[][] { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 4 } }, new Object[] { 1, 2, 3 }));
        pane.setPreferredSize(new Dimension(200, 100));
        return pane;
    }
}