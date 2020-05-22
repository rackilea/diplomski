import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class CharacterAttributesTest {
  public Component makeUI() {
    StyleContext style = new StyleContext();
    StyledDocument doc = new DefaultStyledDocument(style);
    try {
      doc.insertString(0, "abcdefghijklmnopqrstuvwxyz", null);
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    MutableAttributeSet attr1 = new SimpleAttributeSet();
    attr1.addAttribute(StyleConstants.Bold, Boolean.TRUE);
    attr1.addAttribute(StyleConstants.Foreground, Color.RED);
    doc.setCharacterAttributes(5, 8, attr1, false);

    MutableAttributeSet attr2 = new SimpleAttributeSet();
    attr2.addAttribute(StyleConstants.Underline, Boolean.TRUE);
    doc.setCharacterAttributes(3, 20, attr2, false);

    JTextPane textPane = new JTextPane(doc);
    textPane.addCaretListener(e -> {
      if (e.getDot() == e.getMark()) {
        AttributeSet a = doc.getCharacterElement(e.getDot()).getAttributes();
        System.out.println("isBold: " + StyleConstants.isBold(a));
        System.out.println("isUnderline: " + StyleConstants.isUnderline(a));
        System.out.println("Font: " + style.getFont(a));
        System.out.println("Foreground: " + StyleConstants.getForeground(a));
      }
    });

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(textPane));
    return p;
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new CharacterAttributesTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}