JComboBox comboBox = new JComboBox( model )
{
    @Override
    public boolean selectWithKeyChar(char keyChar)
    {
        // remove the listener here

        // This will cause the selected index to change
        Boolean result = super.selectWithKeyChar(keyChar);

        // add the listener back here

        return result;
    }
};