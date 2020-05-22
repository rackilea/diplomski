@Override
public void setValueAt(Object value, int row, int column)
{
    super.setValueAt(value, row, column);

    if (column == 0 || or column == 3)
    {
        double column0 = getValueAt(row, 0);
        double column3 = getValueAt(row, 3);
        double result = column0 * column3;
        setValueAt(result, row, 6);
    }
}