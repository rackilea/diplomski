public class CustomTable extends Table{
    public CustomTable(TableModel model) {
        super(model);
    }
    protected Component createCell(Object value, int row, int column, boolean editable) {
        switch (column) {
            case QUANITY_COLUMN:
                // create custom cell and return
                ...
            default:
                return super.createCell(value, row, column, editable);
        }
    }

}