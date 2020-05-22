import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
  public static void main(String[] argv) throws Exception {
    JTextArea textArea = new JTextArea();
    JScrollPane pane = new JScrollPane(textArea);
    pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

  }
}