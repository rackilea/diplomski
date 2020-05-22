import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TableAndDialog
{
  public static void main(String[] args)
  {
    JTable table = new JTable(new DefaultTableModel(
        new String[][] {{"R1C1", "R1C2"}, {"R2C1", "R2C2"}},
        new String[] {"Column 1", "Column 2"}));

    JFrame f = new JFrame("Frame");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

    JTextField field1 = new JTextField(20);
    JTextField field2 = new JTextField(20);

    JButton insertButton = new JButton("Insert");
    insertButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        ((DefaultTableModel) table.getModel()).addRow(
            new String[] {field1.getText(), field2.getText()});
      }
    });

    JButton button = new JButton("Insert data");
    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        JDialog d = new JDialog(f, "Dialog");
        d.getContentPane().setLayout(new GridLayout(0, 2));
        d.getContentPane().add(new JLabel("Column 1 value"));
        d.getContentPane().add(field1);
        d.getContentPane().add(new JLabel("Column 2 value"));
        d.getContentPane().add(field2);
        d.getContentPane().add(insertButton);
        d.setBounds(400, 600, 300, 200);
        d.setVisible(true);
      }
    });

    f.getContentPane().add(button, BorderLayout.SOUTH);
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}