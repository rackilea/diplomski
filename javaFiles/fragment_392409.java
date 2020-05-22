import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreePath;


public class TreeTest implements Runnable {

    @Override
    public void run() {
        JTree tree = new JTree();
        tree.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                JTree t = (JTree) e.getSource();
                TreePath tp = t.getPathForLocation(e.getX(), e.getY());
                if (tp != null) {
                    t.setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    boolean overIcon = false;
                    tp = t.getClosestPathForLocation(e.getX(), e.getY());
                    if (tp != null && t.getUI() instanceof BasicTreeUI) {
                        BasicTreeUI ui = (BasicTreeUI) tree.getUI();
                        if (isInExpandControl(ui, tp, e)) {
                            overIcon = true;
                            t.setCursor(new Cursor(Cursor.MOVE_CURSOR)); // set another cursor
                        }
                    }
                    if (!overIcon) {
                        t.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
        });
        JFrame frm = new JFrame("Tree test");
        frm.add(new JScrollPane(tree));
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    private boolean isInExpandControl(BasicTreeUI ui, TreePath tp, MouseEvent evt) {
        try {
            Method m = BasicTreeUI.class.getDeclaredMethod("isLocationInExpandControl", TreePath.class, int.class, int.class);
            m.setAccessible(true);
            return Boolean.TRUE.equals(m.invoke(ui, tp, evt.getX(), evt.getY()));
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TreeTest());
    }
}