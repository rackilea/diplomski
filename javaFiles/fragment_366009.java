import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

public class SelectionTypeTest {
  public JComponent makeUI() {
    JTextArea textArea = new JTextArea();
    DefaultHighlighter hl = (DefaultHighlighter) textArea.getHighlighter();
    System.out.println(hl.getDrawsLayeredHighlights());
    hl.setDrawsLayeredHighlights(false);
    textArea.setSelectionColor(Color.RED);
    textArea.setSelectedTextColor(Color.WHITE);
    try (Reader reader = new BufferedReader(new InputStreamReader(
          new FileInputStream("SelectionTypeTest.java"), "UTF-8"))) {
      textArea.read(reader, "");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return new JScrollPane(textArea);
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
    f.getContentPane().add(new SelectionTypeTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}