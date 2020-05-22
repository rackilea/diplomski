import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

public class HTMLTest2 {
  public JComponent makeEditorPane(String bullet) {
    // create editor pane and fill with some html
    JEditorPane pane = new JEditorPane();
    pane.setContentType("text/html");
    pane.setEditable(false);
    if(bullet!=null) {
      HTMLEditorKit htmlEditorKit = (HTMLEditorKit)pane.getEditorKit();
      StyleSheet styleSheet = htmlEditorKit.getStyleSheet();
      //String u = getClass().getResource(bullet).toString();
      String u = "http://i.stack.imgur.com/jV29K.png";
      styleSheet.addRule(String.format("ul{list-style-image:url(%s);margin:0px 20px;", u));
      //styleSheet.addRule("ul{list-style-type:circle;margin:0px 20px;}");
      //styleSheet.addRule("ul{list-style-type:disc;margin:0px 20px;}");
      //styleSheet.addRule("ul{list-style-type:decimal;margin:0px 20px;}");
    }
    pane.setText("<html><h1>Heading</h1>Text<ul><li>Bullet point</li></ul></html>");
    return pane;
  }
  public JComponent makeUI() {
    JPanel p = new JPanel(new GridLayout(2,1));
    p.add(new JScrollPane(makeEditorPane(null)));
    p.add(new JScrollPane(makeEditorPane("bullet.png")));
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new HTMLTest2().makeUI());
    f.setSize(320, 320);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}