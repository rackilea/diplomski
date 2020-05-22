ActionListener al = new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JMenuItem menuItem = (JMenuItem)e.getSource();
        System.out.println(menuItem.getText());
    }
}