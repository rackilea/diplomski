import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class InternalFrameMenu extends JInternalFrame {

    JMenuBar menubar;
    JMenu sales_invoicing;

    JMenuItem jMenuItem1;
    JMenuItem jMenuItem2;
    JMenuItem jMenuItem3;
    JMenuItem jMenuItem4;

    JLabel label = new JLabel(" ");

    public InternalFrameMenu() {
        super("Internal Frame", true, true, true, true);

        menubar = new JMenuBar();
        sales_invoicing = new JMenu("Sales Invoice");
        jMenuItem1 = new JMenuItem("Item 1");
        jMenuItem2 = new JMenuItem("Item 2");
        jMenuItem3 = new JMenuItem("Item 3");
        jMenuItem4 = new JMenuItem("Item 4");

        setBindings();

        sales_invoicing.add(jMenuItem1);
        sales_invoicing.add(jMenuItem2);
        sales_invoicing.add(jMenuItem3);
        sales_invoicing.add(jMenuItem4);

        menubar.add(sales_invoicing);
        setJMenuBar(menubar);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        setSize(250, 250);
        setLocation(20, 20);
    }

    private void setBindings() {
        sales_invoicing.setMnemonic(KeyEvent.VK_S);
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
    }
}