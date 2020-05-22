import java.awt.*;
  import javax.swing.*;
  import javax.swing.text.AbstractDocument;
  import javax.swing.text.AttributeSet;
  import javax.swing.text.BadLocationException;
  import javax.swing.text.DocumentFilter;

class checkText extends DocumentFilter {
public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
        AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, text, attrs);
       GuiTest.enableButton();
       }
      }

 public class GuiTest extends JFrame {
static JFrame inputFrame = new JFrame();
static JTextField myTextfield = new JTextField(10);
static JButton myButton = new JButton("Hi!");

public GuiTest() {
    inputGUI();
}

private static void inputGUI() {
    inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    inputFrame.setTitle("The INPUT");
    inputFrame.setLayout(new FlowLayout());
    inputFrame.setSize(1366, 768);
    inputFrame.setVisible(true);

    inputFrame.add(myButton);

    DocumentFilter filter = new checkText();
    ((AbstractDocument) myTextfield.getDocument()).setDocumentFilter(filter);
    inputFrame.add(myTextfield);
    myButton.setEnabled(false);
}

public static void enableButton() {
    myButton.setEnabled(true);
}

public static void main(String args[]) { new GuiTest(); }
}