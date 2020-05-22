import javax.swing.DefaultDesktopManager;
import javax.swing.DesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class CustomDesktopManager extends DefaultDesktopManager {
    @Override
    public void iconifyFrame(JInternalFrame f) {
        super.iconifyFrame(f);

        JInternalFrame.JDesktopIcon icon = f.getDesktopIcon();
        Dimension prefSize = icon.getPreferredSize();
        icon.setBounds(f.getX(), f.getY(), prefSize.width, prefSize.height);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JDesktopPane desktopPane = new JDesktopPane();
                DesktopManager dm = new CustomDesktopManager();
                desktopPane.setDesktopManager(dm);
                JInternalFrame internalFrame = new JInternalFrame("Test Internal Frame", true, false, true, true);
                internalFrame.setSize(200, 150);
                internalFrame.setVisible(true);
                desktopPane.add(internalFrame);

                frame.add(desktopPane, BorderLayout.CENTER);
                frame.setSize(800, 600);
                frame.setVisible(true);
            }
        });
    }
}