import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WindowEventDemo extends JFrame implements WindowFocusListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new WindowEventDemo("Window Event Demo").setVisible(true);
            }
        });
    }

    public WindowEventDemo(String name) {
        super(name);
        addWindowFocusListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        System.out.println("WindowFocusListener method called: windowGainedFocus.");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println("WindowFocusListener method called: windowLostFocus.");
    }
}