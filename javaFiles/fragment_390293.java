import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/** @see http://stackoverflow.com/questions/7218971 */
public class InternalFrame {

    private static final int DELTA = 40;
    private JDesktopPane desktop = new JDesktopPane();
    private int offset = DELTA;

    public InternalFrame() {
        JFrame f = new JFrame("Add Frame");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(400, 400));
        JPanel p = new JPanel();
        p.add(new JButton(new AbstractAction("Add") {

            @Override
            public void actionPerformed(ActionEvent e) {
                createInternalFrame();
            }
        }));
        f.add(p, BorderLayout.SOUTH);
        createInternalFrame();
        f.add(desktop, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void createInternalFrame() {
        JInternalFrame internalFrame = new JInternalFrame(
            "Internal Frame");//, true, true, true, true);
        desktop.add(internalFrame);
        internalFrame.setLocation(offset, offset);
        offset += DELTA;
        if (System.getProperty("os.name").startsWith("Mac OS")) {
            internalFrame.putClientProperty("JInternalFrame.isPalette", true);
        } else {
            ((BasicInternalFrameUI) internalFrame.getUI()).setNorthPane(null);
        }
        internalFrame.add(createTabbedPane());
        internalFrame.pack();
        internalFrame.setVisible(true);
    }

    // take up some space
    private JTabbedPane createTabbedPane() {
        JTabbedPane jtp = new JTabbedPane();
        createTab(jtp, "One");
        createTab(jtp, "Two");
        return jtp;
    }

    private void createTab(JTabbedPane jtp, String s) {
        jtp.add(s, new JLabel("TabbedPane " + s, JLabel.CENTER));
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                InternalFrame myInternalFrame = new InternalFrame();
            }
        });
    }
}