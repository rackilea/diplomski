import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;

public class InternalFrameMenuTest extends JFrame {

    public InternalFrameMenuTest() {
        JDesktopPane desktop = new JDesktopPane();
        InternalFrameMenu iframe = new InternalFrameMenu();
        desktop.add(iframe);
        iframe.setVisible(true);
        iframe.setFocusable(true);
        try {
            iframe.setSelected(true);
        } catch (Exception ex) {
        }
        add(desktop);
    }

    public static void createAndShowGui() {
        JFrame frame = new InternalFrameMenuTest();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
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