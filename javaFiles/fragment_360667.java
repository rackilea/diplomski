import java.awt.*;
import javax.swing.*;

public class Test implements Runnable
{
  private JTextField firstName;
  private JTextField lastName;
  private JTextField title;
  private JTextField nickname;
  private JComboBox format;

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Test());
  }

  public Test()
  {
    firstName = new JTextField(20);
    lastName = new JTextField(20);
    title = new JTextField(20);
    nickname = new JTextField(20);
    format = new JComboBox();
  }

  public void run()
  {
    JFrame frame = new JFrame();
    frame.getContentPane().add(createPanel());
    frame.pack();
    frame.setVisible(true);
  }

  private JPanel createPanel()
  {
    JPanel p = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(4,4,4,4);
    gbc.ipadx = 1;
    gbc.ipady = 1;
    gbc.anchor = GridBagConstraints.WEST;

    JLabel nameHeader = new JLabel("Name:");
    nameHeader.setForeground(Color.RED.darker());
    p.add(nameHeader, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    p.add(new JSeparator(JSeparator.HORIZONTAL), gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    p.add(new JLabel("First Name"), gbc);

    gbc.gridx = 1;
    p.add(firstName, gbc);

    gbc.gridx = 2;
    p.add(new JLabel("Last Name"), gbc);

    gbc.gridx = 3;
    p.add(lastName, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    p.add(new JLabel("Title"), gbc);

    gbc.gridx = 1;
    p.add(title, gbc);

    gbc.gridx = 2;
    p.add(new JLabel("Nickname"), gbc);

    gbc.gridx = 3;
    p.add(nickname, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    p.add(new JLabel("Format"), gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    p.add(format, gbc);

    return p;
  }
}