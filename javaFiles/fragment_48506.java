JMenuItem myMenuItem = new JMenuItem("Hello");
myMenuItem.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Hello button clicked!"); // or call some other method
    }
});