import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class FrameTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Demo");
        Container cp = jf.getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(new JButton(new AbstractAction("Button Text") {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World");
            }
        }));
        jf.setSize(200, 200);
        jf.setVisible(true);
    }
}