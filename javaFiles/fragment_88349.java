if (o == null)
{
    comboBoxstate.setModel( new DefaultComboBoxModel<String>() );
}
else
{
    comboBoxstate.setModel( new DefaultComboBoxModel<String>( (String[])o ) );
}