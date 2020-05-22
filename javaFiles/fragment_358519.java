/**
 * Wrapping RowSorter for usage (f.i.) in a rowHeader.
 * 
 * Delegates all state queries, 
 * does nothing on receiving notification of model changes,
 * propagates rowSorterEvents from delegates.
 * 
 * Beware: untested! 
 * 
 * @author Jeanette Winzenburg, Berlin
 */
public class RowSorterWrapper<M> extends RowSorter<M> {

    private RowSorter<M> delegate;
    private RowSorterListener rowSorterListener;

    public RowSorterWrapper(RowSorter<M> delegate) {
        this.delegate = delegate;
        delegate.addRowSorterListener(getRowSorterListener());
    }

    /**
     * Creates and returns a RowSorterListener which re-fires received
     * events.
     * 
     * @return
     */
    protected RowSorterListener getRowSorterListener() {
        if (rowSorterListener == null) {
            RowSorterListener listener = new RowSorterListener() {

                @Override
                public void sorterChanged(RowSorterEvent e) {
                    if (RowSorterEvent.Type.SORT_ORDER_CHANGED == e.getType()) {
                        fireSortOrderChanged();
                    } else if (RowSorterEvent.Type.SORTED == e.getType()) {
                        fireRowSorterChanged(null);                }
                }
            };
            rowSorterListener = listener;
        }
        return rowSorterListener;
    }


    @Override
    public M getModel() {
        return delegate.getModel();
    }

    @Override
    public void toggleSortOrder(int column) {
        delegate.toggleSortOrder(column);
    }

    @Override
    public int convertRowIndexToModel(int index) {
        return delegate.convertRowIndexToModel(index);
    }

    @Override
    public int convertRowIndexToView(int index) {
        return delegate.convertRowIndexToView(index);
    }

    @Override
    public void setSortKeys(List keys) {
        delegate.setSortKeys(keys);
    }

    @Override
    public List getSortKeys() {
        return delegate.getSortKeys();
    }

    @Override
    public int getViewRowCount() {
        return delegate.getViewRowCount();
    }

    @Override
    public int getModelRowCount() {
        return delegate.getModelRowCount();
    }

    @Override
    public void modelStructureChanged() {
        // do nothing, all work done by delegate
    }

    @Override
    public void allRowsChanged() {
        // do nothing, all work done by delegate
    }

    @Override
    public void rowsInserted(int firstRow, int endRow) {
        // do nothing, all work done by delegate
    }

    @Override
    public void rowsDeleted(int firstRow, int endRow) {
        // do nothing, all work done by delegate
    }

    @Override
    public void rowsUpdated(int firstRow, int endRow) {
        // do nothing, all work done by delegate
    }

    @Override
    public void rowsUpdated(int firstRow, int endRow, int column) {
        // do nothing, all work done by delegate
    }

}