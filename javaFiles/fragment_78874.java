import java.util.logging.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class SSCCE {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        final JWindow window = new JWindow();
        final JPanel windowContents = new JPanel();
        JLabel label = new JLabel("A window that is pushed into view..........");
        windowContents.add(label);
        window.add(windowContents);
        window.pack();
        window.setLocationRelativeTo(null);
        final int desiredWidth = window.getWidth();
        window.getContentPane().setLayout(null);
        window.setSize(0, window.getHeight());
        window.setVisible(true);
        Timer timer = new Timer(15, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int newWidth = Math.min(window.getWidth() + 1, desiredWidth);
                window.setSize(newWidth, window.getHeight());
                windowContents.setLocation(newWidth - desiredWidth, 0);
                if (newWidth >= desiredWidth) {
                    ((Timer) e.getSource()).stop();
                    //restore original layout
                    window.getContentPane().setLayout(new BorderLayout());
                    window.validate();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SSCCE.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(0);
                }
            }
        });
        timer.start();
    }

    private SSCCE() {
    }
}