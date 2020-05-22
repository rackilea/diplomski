import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class JPopupMenuEx
extends JPopupMenu
implements MouseListener {

    /**
     * 
     */
    private static final long serialVersionUID = -5352058505305990803L;

    @Override
    public void addSeparator() {
        add(new JSeparatorEx());
    }

    @Override
    public JMenuItem add(JMenuItem menuItem) {
        menuItem.addMouseListener(this);
        return super.add(menuItem);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ((JMenuItem)e.getSource()).setArmed(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JMenuItem)e.getSource()).setArmed(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    public class JSeparatorEx extends JSeparator{

        /**
         * 
         */
        private static final long serialVersionUID = 3477309905456341629L;

        public Dimension getPreferredSize() {
            Dimension d = super.getPreferredSize();

            if (d.height==0)
                d.height = 4;

            return d;
        }
    }
}