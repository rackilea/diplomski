import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempTest
{
    public static void main(String[] args)
    {
        UpgradePopupWindow.createGUI(null);
    }
}


class UpgradePopupWindow extends JPanel implements ActionListener {
  public static UpgradePopupWindow mainWindow;

  static final long serialVersionUID = 0;

  final String upgrade = "Continue Upgrade";
  final String restore = "Restore";

  JPanel panels;
  JButton flashMe;
  JButton helpMe;
  JTextArea Message;
    JFrame frame;


    protected JTextArea addText(String text, boolean visible, int fontStyle) {
    JTextArea textArea = new JTextArea(text);

    textArea.setFont(new Font("SansSerif", fontStyle, 12)); //$NON-NLS-1$

    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);
    textArea.setForeground(Color.WHITE);
    textArea.setOpaque(false);
    textArea.setVisible(visible);
    textArea.setAlignmentX(Component.CENTER_ALIGNMENT);

    add(textArea);

    return textArea;
  }

  public UpgradePopupWindow(JFrame frm, Object ft2) {
    String text = "This is the random text for now. I will bother about the actual content later";
    addLabel(text, Font.PLAIN, 12);
      frame = frm;
    flashMe = new JButton(upgrade);
    flashMe.setActionCommand("upgrade");
    flashMe.addActionListener(this);
    flashMe.setEnabled(true);
    add(flashMe);


    helpMe = new JButton(restore);
    helpMe.setActionCommand("restore");
    helpMe.addActionListener(this);
    helpMe.setEnabled(true);
    add(helpMe);
  }

  protected JLabel addLabel(String text, int fontStyle, int size) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("SansSerif", fontStyle, size));
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    label.setOpaque(false);
    label.setVisible(true);
    label.setForeground(Color.BLUE);

    add(label);
    return label;
  }

  public static void createGUI(Object obj) {
    //Create and set up the frame.
    JFrame frame = new JFrame("PopUp Dialog");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //create and setup the content pane
    UpgradePopupWindow popUpContentPane = new UpgradePopupWindow(frame, obj);

    popUpContentPane.setOpaque(true);
    frame.setContentPane(popUpContentPane);

    frame.pack();
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if("restore".equals(e.getActionCommand())) {
      System.out.println("restore button selected");
      frame.dispose();
      SwingUtilities.getWindowAncestor(this).dispose();
    } else if ("upgrade".equals(e.getActionCommand())) {
      System.out.println("upgrade button selected");
      frame.dispose();
    }
  }

}