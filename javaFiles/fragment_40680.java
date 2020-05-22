import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/** @see http://stackoverflow.com/a/10360374/230513 */
public class InternalFrameIcons extends JPanel {

    public InternalFrameIcons() {
        this.setLayout(new GridLayout(0, 1, 5, 5));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(createLabel("InternalFrame.closeIcon"));
        this.add(createLabel("InternalFrame.maximizeIcon"));
        this.add(createLabel("InternalFrame.minimizeIcon"));
    }

    private JLabel createLabel(String name) {
        Icon icon = (Icon) UIManager.get(name);
        JLabel label = new JLabel(name, icon, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        return label;
    }

    private void display() {
        JFrame f = new JFrame("InternalFrameIcons");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new InternalFrameIcons().display();
            }
        });
    }
}