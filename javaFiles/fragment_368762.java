for (int index =0 ; index < tableModel.getRowCount(); index ++)
{
    Object value = tableModel.getValueAt(index, 1);

    if (value.toString().equals("")) 
    {
        JOptionPane.showMessageDialog(panel_4, "Please Enter Discount Amount For All Items");

        return; 
    }
}