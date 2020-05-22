menuItemOpen.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {

        JMenuItem mi = (JMenuItem)e.getSource();
        JPopupMenu popup = (JPopupMenu)mi.getParent();
        JTable table = (JTable)popup.getInvoker();

        if (table.equals(table1))
        {
            textField.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());
        }
        else if (table.equals(table2))
        {
            textField.setText(table2.getValueAt(table2.getSelectedRow(), 1).toString());
        }
        else if (table.equals(table3))
        {
            textField.setText(table3.getValueAt(table3.getSelectedRow(), 2).toString());
        }
    }
});