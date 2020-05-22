import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WindowTest {
//get JFrame

    JFrame JFrame = new JFrame();

    public static JFrame frameA = new JFrame("FrameA");
    public static JFrame frameB = new JFrame("FrameB");
    static WindowTest windowtest = new WindowTest();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                windowtest.frames();
            }
        });
    }

    public void frames() {
        frameA.setLayout(new FlowLayout());
        frameA.setSize(220, 130);
        frameA.setVisible(true);
        frameA.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("A is closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("A has closed");
            }

        });

        frameB.setLayout(new FlowLayout());
        frameB.setSize(220, 130);
        frameB.setVisible(true);
        frameB.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("B is closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("B has closed");
            }

        });
    }
}