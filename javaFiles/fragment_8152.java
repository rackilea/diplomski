import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class TestWordScramble extends JPanel {
   private JTextField txtWord = new JTextField(10);
   private JButton scrambleBtn = new JButton("Scramble");

   public TestWordScramble() {
      scrambleBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String word = getRandomWord(txtWord.getText());
            txtWord.setText(word);
         }
      });

      add(txtWord);
      add(scrambleBtn);
   }

   private String getRandomWord(String text) {
      ArrayList<Character> chars = new ArrayList<Character>();
      for (char c : text.toCharArray()) {
         chars.add(c);
      }
      Collections.shuffle(chars);
      char[] shuffled = new char[chars.size()];
      for (int i = 0; i < shuffled.length; i++) {
         shuffled[i] = chars.get(i);

      }
      String shuffledWord = new String(shuffled);
      return shuffledWord;
   }

   private static void createAndShowGui() {
      TestWordScramble mainPanel = new TestWordScramble();

      JFrame frame = new JFrame("TestWordScramble");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}