JButton button = new JButton("Click Me");
button.addActionListener( new ActionListener()
{
    private boolean firstTime = true;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (firstTime)
        {
            System.out.println( "First Message" );
            firstTime = false;
        }
        else
            System.out.println( "Another Message" );
    }
});