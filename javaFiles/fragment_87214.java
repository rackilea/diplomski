import javax.swing.JFrame;

public class NewClass1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("On Top");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setVisible(true);
        frame.toFront();
    }
}