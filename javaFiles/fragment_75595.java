import javax.swing.JFrame;
import java.awt.Dimension;

public class Ex extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("YOU CAN'T SHRINK ME COMPLETELY!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setMinimumSize(new Dimension(100, 100));
        frame.setVisible(true);
    }
}