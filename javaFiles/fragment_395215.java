import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainClass {
  public static void main(String args[]) {
    JFrame f = new JFrame("JOptionPane Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton button = new JButton("Ask");
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        Component source = (Component) actionEvent.getSource();
        Object response = JOptionPane.showInputDialog(source,
            "Choose One?", "JOptionPane Sample",
            JOptionPane.QUESTION_MESSAGE, null, new String[] { "A", "B", "C" },
            "B");
        System.out.println("Response: " + response);
      }
    };
    button.addActionListener(actionListener);
    f.add(button, BorderLayout.CENTER);
    f.setSize(300, 200);
    f.setVisible(true);
  }
}