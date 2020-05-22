import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class DetailedComboBoxDemo implements Runnable
{
  private DetailedComboBox combo;
  private JTextField name;
  private JTextField capital;

  public void run()
  {
    List<List<?>> tableData = new ArrayList<List<?>>();
    tableData.add(new ArrayList<String>(
                  Arrays.asList("MD", "Maryland", "Annapolis")));
    tableData.add(new ArrayList<String>(
                  Arrays.asList("NH", "New Hampshire", "Concord")));
    tableData.add(new ArrayList<String>(
                  Arrays.asList("NJ", "New Jersey", "Trenton")));
    tableData.add(new ArrayList<String>(
                  Arrays.asList("NM", "New Mexico", "Santa Fe")));
    tableData.add(new ArrayList<String>(
                  Arrays.asList("ND", "North Dakota", "Bismark")));

    String[] columns = new String[]{"State", "Name", "Capital"};
    int[] widths = new int[]{50, 100, 100};

    combo = new DetailedComboBox(columns, widths, 0);
    combo.setTableData(tableData);
    combo.setSelectedIndex(-1);
    combo.setPopupAlignment(DetailedComboBox.Alignment.LEFT);
    combo.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        showDetails();
      }
    });

    name = new JTextField(10);
    capital = new JTextField(10);
    name.setEditable(false);
    capital.setEditable(false);

    JPanel p = new JPanel(new FlowLayout());
    p.add(new JLabel("State"));
    p.add(combo);
    p.add(new JLabel("Name"));
    p.add(name);
    p.add(new JLabel("Capital"));    
    p.add(capital);

    JFrame frame = new JFrame("DetailedComboBox Demo");
    frame.getContentPane().add(p, BorderLayout.CENTER);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  private void showDetails()
  {
    List<? extends Object> rowData = combo.getSelectedRow();
    name.setText(rowData.get(1).toString());
    capital.setText(rowData.get(2).toString());
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new DetailedComboBoxDemo());
  }
}