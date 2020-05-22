final ActionListener pushButton = new ActionListener()
{
    private boolean clicked;
    public void actionPerformed(final ActionEvent e)
    {
        if(clicked)
        {
            JOptionPane.showMessageDialog(null, "Action already started");
            return;
        }
        clicked = true;
        // ... rest of the action to do ...
    }
}