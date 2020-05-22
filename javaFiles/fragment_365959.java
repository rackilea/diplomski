JComboBox comboBox = new JComboBox( model )
{
    @Override
    public boolean selectWithKeyChar(char keyChar)
    {
        return false;
    }
};