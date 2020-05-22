import java.awt.*;
import javax.swing.*;

public class QueryScreen extends MainScreen
{
  final JPanel queryList = new JPanel();

  public QueryScreen()
  {
    tabbedPane.addTab("Query List", queryList);
    //add( tabbedPane, BorderLayout.CENTER );    /* not needed */
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        JFrame frame = new QueryScreen();
        frame.setSize(300, 200);
        frame.setVisible(true);
      }
    });
  }
}