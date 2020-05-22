MenuItem aboutItem = new MenuItem("Accept");
aboutItem.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent evt)
    {
        System.out.println("Accept clicked!");
    }
});