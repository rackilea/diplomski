bSquare.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // just use a new variable here
        // default to 0 (if a NumberFormatException occurs)
        int val = 0;
        try
        {
            val = Integer.parseInt(textfield.getText());
            textarea.setText(String.valueOf(val));
        }
        catch (NumberFormatException nfe)
        {
            textarea.setText("Error!");
        }

        for (int j = 0; j < val; j++)
        {
            textarea.append("");
            for (int i = 0; i < val; i++)
            {
                textarea.append("X");
            }
        }
    }
});