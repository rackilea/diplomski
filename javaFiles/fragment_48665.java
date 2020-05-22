import java.awt.*;
import javax.swing.*;

class ButtonFrame extends JFrame
{
  JButton button;

  ButtonFrame(String title)
  {
    super(title);
    setLayout(new FlowLayout());

    button = new JButton("OK");
    add(button);

    JRootPane rootPane = SwingUtilities.getRootPane(button);
    rootPane.setDefaultButton(button);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

public class Sample
{
  public static void main ( String[] args )
  {
    ButtonFrame frame = new ButtonFrame("Demo");

    frame.setSize(200,80);
    frame.setVisible(true);
  }
}