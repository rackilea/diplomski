private class ButtonListenerT implements ActionListener
{
    public void actionPerformed (ActionEvent event)
    {
        double total;
        total = Double.parseDouble(resultLabel.getText());
        resultLabel.setText ("Total plus tax: " + (total *1.07));           
    }
}