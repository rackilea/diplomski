import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PanelOnClickGrabFocus {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final JPanel p = new JPanel();
                p.setPreferredSize(new Dimension(400, 400));
                JTextField tf = new JTextField(34);
                p.add(tf);
                f.setContentPane(p);
                f.pack();
                f.setVisible(true);
                p.addMouseListener(new MouseAdapter() {    
                    @Override
                    public void mousePressed(MouseEvent e) {
                        p.requestFocus();
                    }
                });
            }
        });
    }
}