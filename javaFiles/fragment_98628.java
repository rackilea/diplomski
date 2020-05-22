public class A extends JComponent implements ActionListener
{
    private JTextField updateField;

    public A(JTextField updateField[,<your other contructor arguments>...])
    {
        this.updateField = updateField;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource().equals(this)
        {
            //copy, paste or do whatever with the JTextField
            //by way of this.updateField;
            //e.g. this.updateField.setText(...);
            //or to simply pass the event along to the JTextField's handlers
            //this.updateField.dispatchEvent(event);
        }
    }
}