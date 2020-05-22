btnBack.addActionListener(new ActionListener() 
{
    public void actionPerformed(ActionEvent e) 
    {
       AbstractButton button = (AbstractButton) e.getSource();
       Window window = SwingUtilities.getWindowAncestor(button);
       window.dispose();
    }
});