import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AutoHide {

    public static void main(String[] args) {
        new AutoHide();
    }

    private Timer autoHideTimer;

    public AutoHide() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JLabel("Auto Hide"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                autoHideTimer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });
                autoHideTimer.setRepeats(false);

                frame.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseExited(MouseEvent e) {
                        System.out.println("Restart...");
                        autoHideTimer.restart();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        System.out.println("Stop");
                        autoHideTimer.stop();
                    }
                });

            }
        });
    }

}