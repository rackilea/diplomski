btnDone = new JButton(new CloseFrameAction());

...

private class CloseFrameAction extends AbstractAction
{
    public CloseFrameAction()
    {
         super("Done");
    }

    public void actionPerformed(ActionEvent e) 
    {
        frame.dispose();
        setEnabled(false);
    }
}