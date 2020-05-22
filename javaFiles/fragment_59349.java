@Override
public void setValueAt(Object newValue, int row, int column)
{
    Object oldValue = getValueAt(row, column);

    // do processing with your "oldValue" and the "newValue"

    super.setValueAt(...);
}