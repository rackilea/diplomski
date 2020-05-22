import java.awt.*;
import javax.swing.*;

public class Test extends JFrame
{
  public Test()
  {
    super();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 200);

    onInit();

    setVisible(true);
  }
  private void onInit()
  {
    JLayeredPane lp = getLayeredPane();

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(new JTextArea(), BorderLayout.CENTER);
    panel.add(new JButton("Submit"), BorderLayout.SOUTH);
    panel.setSize(300, 150); // Size is needed here, as there is no layout in lp

    JPanel glass = new JPanel();
    glass.setOpaque(false); // Set to true to see it
    glass.setBackground(Color.GREEN);
    glass.setSize(300, 150);
    glass.setLocation(10, 10);

    lp.add(panel, Integer.valueOf(1));
    lp.add(glass, Integer.valueOf(2));
  }

  public static void main(String args[])
  {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        new Test();
      }
    });
  }
}