JButton button = new JButton("Do Something");
button.addActionListener( new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Do Something Clicked");
    }
});