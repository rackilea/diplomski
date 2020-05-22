import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JTreeSelectDeselect {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JTree tree = new JTree();

        tree.setCellRenderer(getDefaultTreeCellRenderer());
        tree.addMouseListener(getMouseListener(tree));
        tree.addFocusListener(getFocusListener(tree));

        panel.add(tree, BorderLayout.LINE_START);
        panel.add(new JScrollPane(new JTextArea(10, 30)));
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    private static DefaultTreeCellRenderer getDefaultTreeCellRenderer() {
        DefaultTreeCellRenderer defaultTreeCellRenderer = new DefaultTreeCellRenderer();
        defaultTreeCellRenderer.setBackgroundSelectionColor(new Color(86, 92, 160));
        defaultTreeCellRenderer.setBackgroundNonSelectionColor(new Color(135, 151, 53));
        defaultTreeCellRenderer.setBackground(new Color(225, 225, 221, 255));
        defaultTreeCellRenderer.setForeground(new Color(225, 225, 221, 255));
        return defaultTreeCellRenderer;
    }

    private static FocusListener getFocusListener(final JTree tree) {
        return new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focus lost");
                tree.clearSelection();
            }
        };
    }

    private static MouseListener getMouseListener(final JTree tree) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse clicked");
                if(tree.getRowForLocation(e.getX(),e.getY()) == -1) {
                    System.out.println("clicked outside a specific cell");
                    tree.clearSelection();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }
}