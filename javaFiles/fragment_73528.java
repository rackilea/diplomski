import static javax.swing.GroupLayout.DEFAULT_SIZE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextSizeProblem3 extends JFrame {
  public TextSizeProblem3() {

    String dummyString = "";
    for (int i = 0; i < 100; i++) {
      dummyString += " word" + i;  //Create a long text
    }
    JTextArea text = new JTextArea();
    text.setText(dummyString);
    text.setLineWrap(true);
    text.setWrapStyleWord(true);

    JButton packMeButton = new JButton("pack");
    packMeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pack();
      }
    });

    GroupLayout layout = new GroupLayout(this.getContentPane());
    getContentPane().setLayout(layout);
    layout.setVerticalGroup(layout.createParallelGroup()
        .addComponent(packMeButton)
        .addComponent(text)
    );
    layout.setHorizontalGroup(layout.createSequentialGroup()
        .addComponent(packMeButton)
        .addComponent(text, DEFAULT_SIZE, 400, 400) //Lock the width to 400
    );

    pack();
    layout.invalidateLayout(this.getContentPane());
    pack();
  }

  public static void main(String args[]) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new TextSizeProblem3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}