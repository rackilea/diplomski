class SpinnerEditor extends DefaultCellEditor
{
    private JSpinner spinner;

    public SpinnerEditor()
    {
        super( new JTextField() );
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 5));
        spinner.setBorder( null );
    }

    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        spinner.setValue( value );
        return spinner;
    }

    public Object getCellEditorValue()
    {
        return spinner.getValue();
    }
}