public void actionPerformed(ActionEvent e)
{
    if (e.getActionCommand() == "GET TIME")
    {
        now = new Date();
        JOptionPane.showMessageDialog(null, "Time "+dateFormatter.format(now),