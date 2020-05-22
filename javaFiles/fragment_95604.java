JFrame frame = new JFrame();
frame.addWindowListener(new WindowAdapter()
{
    @Override
    public void windowClosing(WindowEvent e)
    {
        super.windowClosing(e);
        // Do your disconnect from the DB here.
    }
});