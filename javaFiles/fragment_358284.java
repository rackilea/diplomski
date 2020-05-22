import javax.swing.*;
import java.awt.GridLayout;

public class SimpleCheckBox
{
  public static void main(String[] args)
  {
    JCheckBox checkBox = new JCheckBox("Active");
    checkBox.addActionListener(e -> System.out.println("User clicked the check box"));

    JButton print = new JButton("Print status");
    print.addActionListener(e -> System.out.println("Selected: " + checkBox.isSelected()));

    JButton select = new JButton("Select");
    select.addActionListener(e -> checkBox.setSelected(true));

    JButton deselect = new JButton("Deselect");
    deselect.addActionListener(e -> checkBox.setSelected(false));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new GridLayout(4, 1));
    f.getContentPane().add(checkBox);
    f.getContentPane().add(print);
    f.getContentPane().add(select);
    f.getContentPane().add(deselect);
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}