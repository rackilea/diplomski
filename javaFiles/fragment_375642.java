import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class CustomTip implements Runnable {

    private Popup popup;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CustomTip());
    }

    @Override
    public void run() {
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (popup != null) {
                    popup.hide();
                }
                JLabel text = new JLabel("You've clicked at: " + e.getPoint());
                popup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), text, e.getXOnScreen(), e.getYOnScreen());
                popup.show();
            }
        });
        JFrame frm = new JFrame("Test");
        frm.add(panel);
        frm.setSize(400, 300);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

}