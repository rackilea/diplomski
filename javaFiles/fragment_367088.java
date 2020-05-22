import java.awt.*;
import javax.swing.*;

public class MainScreen extends JFrame
{
  JTabbedPane tabbedPane = new JTabbedPane();
  final JPanel entrance = new JPanel();

  public MainScreen()
  {
    tabbedPane.addTab("Entrance", entrance);
    add(tabbedPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        JFrame frame = new MainScreen();
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    });
  }
}