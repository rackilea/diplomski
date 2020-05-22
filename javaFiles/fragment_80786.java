import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class SalesMenu extends JFrame {

    JMenuBar menubar;
    JMenu sales_invoicing;

    JMenuItem jMenuItem1;
    JMenuItem jMenuItem2;
    JMenuItem jMenuItem3;
    JMenuItem jMenuItem4;

    public SalesMenu() {
        menubar = new JMenuBar();
        sales_invoicing = new JMenu("Sales Invoice");
        jMenuItem1 = new JMenuItem("Item 1");
        jMenuItem2 = new JMenuItem("Item 2");
        jMenuItem3 = new JMenuItem("Item 3");
        jMenuItem4 = new JMenuItem("Item 4");

        sales_invoicing.add(jMenuItem1);
        sales_invoicing.add(jMenuItem2);
        sales_invoicing.add(jMenuItem3);
        sales_invoicing.add(jMenuItem4);

        setBindings();

        menubar.add(sales_invoicing);
        setJMenuBar(menubar);

    }

    private void setBindings(){
        sales_invoicing.setMnemonic(KeyEvent.VK_S);
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
    }

    public static void createAndShowGui() {
        JFrame frame = new SalesMenu();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}