import javax.swing.*;
import java.awt.*;

public class LayoutComponents
{
  public static void main(String[] args)
  {
    JLabel nameOfApp = new JLabel("App Name: ");
    JLabel passOfApp = new JLabel("App password: ");
    JLabel descOfApp = new JLabel("Description: ");

    JTextField appName = new JTextField();
    JTextField appPass = new JTextField();
    JTextField appDesc = new JTextField();

    JButton add = new JButton("Add");
    JButton delete = new JButton("Delete");
    JButton update = new JButton("Update");

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(add);
    buttonPanel.add(delete);
    buttonPanel.add(update);

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new GridBagLayout());

    f.getContentPane().add(nameOfApp, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(appName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(passOfApp, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(appPass, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(descOfApp, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(appDesc, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(buttonPanel, new GridBagConstraints(0, 3, 2, 1, 1.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}