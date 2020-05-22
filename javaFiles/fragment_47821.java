import javax.swing.*;
import java.awt.*;

public class TextAreaTester {
   public static void main(String[] args) {
      new TextAreaTester();
   }

   public TextAreaTester() {
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      // panel.setPreferredSize(new Dimension(100,400));
      for (int i = 0; i < 3; i++) {
         JPanel item = new JPanel(new BorderLayout());
         // item.setLayout(new BoxLayout(item,BoxLayout.LINE_AXIS));
         JTextArea textarea = new JTextArea(
               "this is a line of text I want to wrap if necessary", 3, 35);
         textarea.setWrapStyleWord(true);
         textarea.setLineWrap(true);
         // textarea.setMaximumSize(textarea.getPreferredSize());
         // item.setMaximumSize( item.getPreferredSize() );
         item.add(new JScrollPane(textarea), BorderLayout.NORTH);
         panel.add(item);
      }
      panel.add(Box.createGlue());

      JPanel mainPanel = new JPanel(new BorderLayout()) {
         private final int prefW = 100;
         private final int prefH = 400;

         @Override
         public Dimension getPreferredSize() {
            return new Dimension(prefW, prefH);
         }
      };
      // mainPanel.setPreferredSize(new Dimension(100, 400));
      mainPanel.add(panel, BorderLayout.PAGE_START);

      frame.add(mainPanel);
      frame.setVisible(true);
      // frame.getContentPane().add(jp);
      frame.pack();
   }
}