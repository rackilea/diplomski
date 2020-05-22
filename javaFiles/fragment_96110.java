import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;

/** @see http://stackoverflow.com/questions/5822810 */
public class LayoutPanel extends JPanel {

    public LayoutPanel(boolean useGrid) {
        if (useGrid) {
            this.setLayout(new GridLayout());
        } // else default FlowLayout
        this.add(new JTree());
    }

    private static void display() {
        JFrame f = new JFrame("LayoutPanels");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(1, 0));
        f.add(new LayoutPanel(false));
        f.add(new LayoutPanel(true));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }
}