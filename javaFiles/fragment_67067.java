import javax.swing.*;

public class JLabelLongTextDemo implements Runnable
{
  public static void main(String args[])
  {
    SwingUtilities.invokeLater(new JLabelLongTextDemo());
  }

  public void run()
  {
    JLabel label = new JLabel("Hello");

    String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + 
//                      "quick brown fox jumped over the lazy dog.";

    JTextArea textArea = new JTextArea(2, 20);
    textArea.setText(text);
    textArea.setWrapStyleWord(true);
    textArea.setLineWrap(true);
    textArea.setOpaque(false);
    textArea.setEditable(false);
    textArea.setFocusable(false);
    textArea.setBackground(UIManager.getColor("Label.background"));
    textArea.setFont(UIManager.getFont("Label.font"));
    textArea.setBorder(UIManager.getBorder("Label.border"));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(label, BorderLayout.NORTH);
    frame.getContentPane().add(textArea, BorderLayout.CENTER);
    frame.setSize(100,200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}