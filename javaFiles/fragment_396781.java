import java.awt.Color;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class PopupTest implements Runnable {

    private Popup popup;

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frm = new JFrame("Popup test");
        JLabel label = new JLabel("Click somewhere right mouse button to get a popup");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if (popup != null) {
                        popup.hide();
                    }
                    JTextField field = new JTextField(10);
                    JLabel lbl = new JLabel("Enter text here: ");
                    JPanel p = new JPanel();
                    p.add(lbl);
                    p.add(field);
                    p.setBorder(new LineBorder(Color.BLACK));
                    popup = PopupFactory.getSharedInstance().getPopup(label, p, e.getXOnScreen(), e.getYOnScreen());
                    // we need some logic for a heavy-weight popup
                    Window win = SwingUtilities.windowForComponent(p);
                    if (win instanceof JWindow) {
                        // if heavy weight make the window focusable
                        win.setFocusableWindowState(true);
                        // and install focus listener to hide popup when it lost focus
                        win.addWindowFocusListener(new WindowFocusListener() {

                            @Override
                            public void windowLostFocus(WindowEvent e) {
                                if (popup != null) {
                                    popup.hide();
                                }
                            }

                            @Override
                            public void windowGainedFocus(WindowEvent e) {
                                // TODO Auto-generated method stub

                            }
                        });
                    }
                    popup.show();
                    field.requestFocus();
                }
            }
        });
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {
                if (popup != null) {
                    popup.hide();
                }
            }
        });
        frm.add(label);
        frm.setSize(500, 200);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PopupTest());
    }
}