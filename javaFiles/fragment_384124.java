import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TestJList {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JList list = new JList(new Object[] { "One", "Two", "Three" }) {
                    @Override
                    public int locationToIndex(Point location) {
                        int index = super.locationToIndex(location);
                        if (index != -1 && !getCellBounds(index, index).contains(location)) {
                            return -1;
                        }
                        else {
                            return index;
                        }
                    }
                };

                list.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JList list = (JList) e.getSource();
                        if (list.locationToIndex(e.getPoint()) == -1 && !e.isShiftDown()
                                && !isMenuShortcutKeyDown(e)) {
                            list.clearSelection();
                        }
                    }

                    private boolean isMenuShortcutKeyDown(InputEvent event) {
                        return (event.getModifiers() & Toolkit.getDefaultToolkit()
                                .getMenuShortcutKeyMask()) != 0;
                    }
                });

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(new JScrollPane(list));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}