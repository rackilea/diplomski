import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyProblem {

    private JFrame frame = new JFrame();

    public static void main(String[] args) {
        new MyProblem();
    }

    public MyProblem() {
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 0;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.ipadx = 0;
        gc.ipady = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.NORTH;
        for (int i = 0; i < 3; i++) {
            JButton button = new JButton("Button " + i);
            frame.add(button, gc);
            gc.gridy++;
        }
        gc.weighty = 1;
        frame.add(Box.createGlue(), gc); //Adding a component to feel the area.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}