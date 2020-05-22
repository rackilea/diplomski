import java.awt.*;
import java.io.IOException;
import java.time.LocalTime;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

public class EditorPaneInsertTest {
  private Component makeUI() {
    HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
    JEditorPane editor = new JEditorPane();
    editor.setEditorKit(htmlEditorKit);
    editor.setText("<html><body id='body'>image</body></html>");
    editor.setEditable(false);

    JButton insertBeforeEnd = new JButton("insertBeforeEnd");
    insertBeforeEnd.addActionListener(e -> {
      HTMLDocument doc = (HTMLDocument) editor.getDocument();
      Element elem = doc.getElement("body");
      String line = LocalTime.now().toString();
      String htmlText = String.format("<p>%s</p>", line);
      try {
        doc.insertBeforeEnd(elem, htmlText);
      } catch (BadLocationException | IOException ex) {
        ex.printStackTrace();
      }
    });

    Box box = Box.createHorizontalBox();
    box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    box.add(Box.createHorizontalGlue());
    box.add(insertBeforeEnd);

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(editor));
    p.add(box, BorderLayout.SOUTH);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new EditorPaneInsertTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}