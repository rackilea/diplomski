import com.apple.eawt.Application;
import com.apple.eawt.FullScreenUtilities;
import com.apple.eawt.QuitStrategy;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {

    public static void main(String[] args) {
        Application.getApplication().setQuitStrategy(QuitStrategy.CLOSE_ALL_WINDOWS);
        Application.getApplication().disableSuddenTermination();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setUndecorated(true);
                FullScreenUtilities.setWindowCanFullScreen(frame, true);
                frame.setLayout(new GridBagLayout());
                JButton close = new JButton("Close me");
                close.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });
                frame.add(close);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.out.println("Closed");
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("Closing");
                    }

                });
                frame.setLocationRelativeTo(null);
                //Application.getApplication().requestToggleFullScreen(frame);
                //frame.setVisible(true);
                GraphicsEnvironment.getLocalGraphicsEnvironment()
                                .getDefaultScreenDevice()
                                .setFullScreenWindow(frame);
            }
        });
    }
}