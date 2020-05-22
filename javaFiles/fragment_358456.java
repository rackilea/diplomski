import java.awt.Color;
import javax.swing.*;

public class Test {
   public static void main(String[] args) {

      JTextArea textArea = new JTextArea(10, 30);

      textArea.setText("This is a text");

      Highlighter highlighter = textArea.getHighlighter();
      HighlightPainter painter = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
      int p0 = text.indexOf("is");
      int p1 = p0 + "is".length();
      highlighter.addHighlight(p0, p1, painter );

      JOptionPane.showMessageDialog(null, new JScrollPane(textArea));          
   }
}