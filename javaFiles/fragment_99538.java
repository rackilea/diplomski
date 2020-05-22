package foo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
// Field Variables
private int counter;
private int currentNumber = 0;

// Methods
public void setCounter(int counter) {
    currentNumber = counter;
}

public int getCounter() {
    return currentNumber;
}

public void IncrementCounter() {
    currentNumber++;
    updateLabel();
}

void updateLabel() {
    tCounter.setText(currentNumber + "");
}

public void DecrementCounter() {
    currentNumber = 222;
    updateLabel();
}

public static void main(String... args) {
    MainFrame frame = new MainFrame("Foo");
    frame.pack();
    frame.setVisible(true);
}

final JTextField tCounter = new JTextField();

public MainFrame(String title) {
    super(title);

    // SetLayout
    setLayout(new GridLayout(2, 2));

    // Add Swing components
    tCounter.setEditable(false);
    updateLabel();

    JTextField label = new JTextField();
    label.setText("The Count: ");
    label.setEditable(false);

    JButton btn1 = new JButton("up");
    JButton btn2 = new JButton("down");

    // Add components to content pane

    getContentPane().add(btn1);
    getContentPane().add(btn2);
    getContentPane().add(label);
    getContentPane().add(tCounter);

    // Add btn1 ad btn2 behaviour.
    btn1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            IncrementCounter();
        }
    });

    // Add btn2 Behaviour
    btn2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            DecrementCounter();

        }
    });

}
}