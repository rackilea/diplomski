JTable songDataTable = new JTable()
{
    @Override boolean isCellEditatable(int row, int column)
    {
        return false;
    }
};