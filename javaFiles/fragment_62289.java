import javax.swing.*;
import java.awt.*;
public class GUIExample {
    JFrame frame;
    JLabel label1, label2, label3;
    JPanel topPane, radioPane;
    JRadioButton radio1, radio2, radio3;
    public static void main(String[] args) {
        new GUIExample();
    }

    GUIExample () {
        frame = new JFrame();

        topPane = new JPanel();
        radioPane = new JPanel();
        topPane.setLayout(new FlowLayout());
        // radioPane.setLayout(new BoxLayout(radioPane, BoxLayout.PAGE_AXIS)); //Vertical align
        radioPane.setLayout(new FlowLayout()); //Horizontal align

        label1 = new JLabel("Car");
        label2 = new JLabel("Motorcycle");
        label3 = new JLabel("Truck");

        radio1 = new JRadioButton("Radio1");
        radio2 = new JRadioButton("Radio2");
        radio3 = new JRadioButton("Radio3");

        topPane.add(label1);
        topPane.add(label2);
        topPane.add(label3);

        radioPane.add(radio1);
        radioPane.add(radio2);
        radioPane.add(radio3);

        frame.add(topPane, BorderLayout.PAGE_START);
        frame.add(radioPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}