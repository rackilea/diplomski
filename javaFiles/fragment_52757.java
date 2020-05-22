import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Extend JPanel so we can put the buttons somewhere
// Implement ActionListener so we can listen to them
public class Demo extends JPanel implements ActionListener {

    public JButton one;
    public JButton two;
    public JButton three;

    // This holds the same objects as above. You don't need both.
    public JButton demoArray[] = new JButton[3];

    // This is used to show the results
    public static void main(String[] args) {
        // Create our Demo
        Demo demo = new Demo();

        JFrame frame = new JFrame("Test");
        frame.add(demo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Using uppercase for Class name and lower case for objects
    public Demo() {

        super();

        // Create our buttons            
        one = new JButton("one");
        two = new JButton("two");
        three = new JButton("three");

        // Put them in the array.
        // We could have just created them in the array directly.
        demoArray[0] = one;
        demoArray[1] = two;
        demoArray[2] = three;

        // Put the buttons inside this (the JPanel)
        // and listen to them
        for (JButton button : demoArray) {
            add(button);
            button.addActionListener(this);
        }
    }

    // What to do when we hear them
    @Override
    public void actionPerformed(ActionEvent e) {
        // There are only three buttons, not four
        // That is, demoArray[0], demoArray[1], 
        // and demoArray[2]
        for (int i = 0; i < 3; i++) {
            demoArray[i].setEnabled(false);
        }
    }
}