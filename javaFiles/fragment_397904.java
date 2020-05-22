package windowhandle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Brandon
 */
public class WindowHandle {

    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JTextArea t = new JTextArea();
        t.setPreferredSize(new Dimension(500, 100));
        f.setLayout(new BorderLayout(0, 0));
        f.getContentPane().add(t, BorderLayout.CENTER);
        f.pack();

        natives.Natives.RedirectOutput(t);        
        natives.Natives.ResetOutput();
    }
}