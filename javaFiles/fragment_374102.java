textField.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(final ActionEvent evt)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                textField.setText(null);
                System.out.println("event received:[" + evt.getActionCommand() + "]");
            }
        });
    }
});