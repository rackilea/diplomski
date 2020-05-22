import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SSCCE {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Title of the Frame");
        JPanel panel = new JPanel();

        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");

        panel.add(b1);
        panel.add(b2);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}