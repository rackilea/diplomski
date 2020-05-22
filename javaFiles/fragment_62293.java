// In the view:
someButton.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = someTextField.getText();
        Date d = someFormattedTextField.getDate();
        int i = someSlider.getValue();

        // The controller validates the given input, and
        // eventually calls some methods on the Model,
        // possibly using the given input values
        controller.process(s, i, d);
    }
});