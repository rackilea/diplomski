private class ButtonListener0 implements ActionListener
{
    public void actionPerformed (ActionEvent event)
    {
        resultLabel.setText(String.valueOf(Double.parseDouble(resultLabel.getText()) + 10.00));        
    }
}