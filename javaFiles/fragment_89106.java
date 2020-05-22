import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordField1 extends JApplet implements ActionListener {
  /* Declaration */
  private JPasswordField Input;
  private JTextField Echo;
  private Container Panel;
  private LayoutManager Layout;

  public PasswordField1 () {
    /* Instantiation */
    Input = new JPasswordField ("", 20);
    Layout = new FlowLayout ();
    Panel = getContentPane ();

    /* Location */
    Panel.setLayout (Layout);
    Panel.add (Input);

    /* Configuration */
    Input.addActionListener (this);
  }

  public void actionPerformed (ActionEvent e) {
    char [] Chars;
    String Word;
    Chars = Input.getPassword();
    Word = new String(Chars);
    System.out.println("You Entered: " + Word);
  }
}