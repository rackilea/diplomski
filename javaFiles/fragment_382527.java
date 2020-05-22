import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLEditorKit;

public class StyleTestApp {
    public static void main(final String[] args) {
        final JFrame f = new JFrame("test");
        //f.getContentPane().add(new JTextArea("<html>HELLO <font size=\"3\" face=\"verdana\" color=\"red\">WORLD</font></html>"));
        final JTextPane p = new JTextPane();
        // the HTMLEditorKit is not enabled by default in the JTextPane class.
        p.setEditorKit(new HTMLEditorKit());
        p.setText("<html>HELLO <font size=\"3\" face=\"verdana\" color=\"red\">WORLD</font></html>");
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(true);
    }
}