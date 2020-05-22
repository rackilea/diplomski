Window window = SwingUtilities.windowForComponent(this);
window.addWindowListener( new WindowAdapter()
{
    @Override
    public void windowActivated(WindowEvent e)
    {
        displayWindow.setVisible( true );
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        displayWindow.setVisible( false );
    }
});