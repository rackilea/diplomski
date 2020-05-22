import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JEdit2 extends JFrame  {
   TextArea2 textA = new TextArea2();
   JPanel panel;

   public static void main(String[] args) {
      new JEdit2();
   }

   public JEdit2() {
      setTitle("JEdit 2");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panel = (JPanel) this.getContentPane();
      panel.add(textA, BorderLayout.CENTER);

      pack(); //!! added
      setLocationRelativeTo(null);
      setVisible(true);
   }

}

@SuppressWarnings("serial")
class TextArea2 extends JPanel {
   JTextArea textA = new JTextArea(500, 500); // !! this is one friggin' huge JTextArea!
   JScrollPane areaScrollPane = new JScrollPane(textA);

   public TextArea2() {
      textA.setEditable(true);
      textA.setForeground(Color.WHITE);
      textA.setBackground(Color.DARK_GRAY);
      this.setFont(null);

      setLayout(new BorderLayout()); //!! added
      add(areaScrollPane, BorderLayout.CENTER);
   }
}