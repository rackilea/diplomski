import javax.swing.*;
import java.awt.*;

public class Example {

    JFrame frameA = new JFrame("Example");
    JTextArea textA = new JTextArea();

    public Example() {
        frameA.setSize(600, 300);
        frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frameA.getContentPane(); // Set the Color of textA.
        textA.setForeground(Color.red);
        content.add(textA);
        frameA.setVisible(true);
    }

    public static void main(String[] args) {
        Example exam = new Example();
    }
}