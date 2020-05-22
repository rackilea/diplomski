private class MyListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(locationBox.getSelectedItem() + " selected.");
    }
}