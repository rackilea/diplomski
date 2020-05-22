import java.awt.*;
import java.awt.event.*;

public class ConsumptionGUI extends Frame
{
  public ConsumptionGUI()
  {
    Frame fr = new Frame();
    Button b1 = new Button("Terminate Program");
    Button b2 = new Button("Start");
    //b1.setBounds(50, 50, 50, 50); // Unnecessary
    //b2.setBounds(50, 50, 50, 50); // Unnecessary
    b1.addActionListener(e -> System.exit(0));
    b2.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        InputDialog dialog = new InputDialog(fr);
        dialog.setVisible(true);
        System.out.println("User inputted speed = " + dialog.getSpeed());
      }
    });
    Label txt = new Label("This is my first GUI");
    //add to frame (after all buttons and text was added)
    fr.add(b2);
    fr.add(txt);
    fr.add(b1);
    fr.setSize(500, 300);
    fr.setTitle("Vehicles Information System");
    fr.setLayout(new FlowLayout());
    fr.setVisible(true);
  } //end constructor

  public static void main(String args[])
  {
    ConsumptionGUI frame1 = new ConsumptionGUI();
  } //end main
}

class InputDialog extends Dialog
{
  private int speed;

  InputDialog(Frame owner)
  {
    super(owner, "Input", true);
    addWindowListener(new WindowAdapter()
    {
      @Override
      public void windowClosing(WindowEvent e)
      {
        dispose();
      }
    });

    TextField textField = new TextField(20);

    Button okButton = new Button("OK");
    okButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String speedString = textField.getText();
        speed = !speedString.isEmpty() ? Integer.parseInt(speedString) : 0;
        dispose();
      }
    });

    setLayout(new GridLayout(3, 1));
    add(new Label("Please enter your car's speed"));
    add(textField);
    add(okButton);
    pack();
  }

  int getSpeed()
  {
    return speed;
  }
}