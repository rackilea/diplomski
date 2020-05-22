package overflow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/** @see https://stackoverflow.com/posts/6514889 */
public class InternalFrame extends JFrame {

    JButton openButton;
    JLayeredPane desktop;
    JInternalFrame internalFrame;

    public InternalFrame() {
        super("Click button to open internal frame with two tabs.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 400));
        openButton = new JButton("Open");
        JPanel p = new JPanel();
        p.add(openButton);
        this.add(p, BorderLayout.SOUTH);
        openButton.addActionListener(new OpenListener());
        desktop = new JDesktopPane();
        this.add(desktop, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    class OpenListener implements ActionListener {

        private static final int DELTA = 40;
        private int offset = DELTA;

        public void actionPerformed(ActionEvent e) {
            internalFrame = new JInternalFrame(
                "Internal Frame", true, true, true, true);
            internalFrame.setLocation(offset, offset);
            offset += DELTA;
            internalFrame.add(createTabbedPane());
            desktop.add(internalFrame);
            internalFrame.pack();
            internalFrame.setVisible(true);
        }
    }

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
                myInternalFrame.setVisible(true);
            }
        });
    }
}