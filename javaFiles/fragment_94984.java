@Override
public void propertyChange(PropertyChangeEvent e)
{
    //  A cell has started/stopped editing

    if ("tableCellEditor".equals(e.getPropertyName()))
    {
        if (table.isEditing())
            // disable buttons;
        else
            // enable buttons;
    }
}