public class ResourcesConfigCheckEditingSupport extends EditingSupport{
    private CheckboxCellEditor cellEditor;


    public ResourcesConfigCheckEditingSupport(ColumnViewer viewer) {
        super(viewer);
        // TODO Auto-generated constructor stub
        //cellEditor = new CheckboxCellEditor(null, SWT.CHECK | SWT.READ_ONLY);
        cellEditor = new CheckboxCellEditor(((TableViewer)viewer).getTable());
    }

    @Override
    protected CellEditor getCellEditor(Object element) {
        // TODO Auto-generated method stub
        return cellEditor;
    }

    @Override
    protected boolean canEdit(Object element) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected Object getValue(Object element) {
        // TODO Auto-generated method stub
        return ((TableMetaData) element).getIsSelected();
    }

    @Override
    protected void setValue(Object element, Object value) {
        // TODO Auto-generated method stub
        ((TableMetaData) element).setIsSelected(Boolean.valueOf((boolean) value));
        getViewer().update(element, null);

    }
}