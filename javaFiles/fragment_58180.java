//----> start hack around core issue 6791934: 
//      table not updated correctly after updating model
//      while having a sorter with filter.

    /**
     * Overridden to hack around core bug 
     * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6791934
     * 
     */
    @Override
    public void sorterChanged(RowSorterEvent e) {
        super.sorterChanged(e);
        postprocessSorterChanged(e);
    }


    /** flag to indicate if forced revalidate is needed. */
    protected boolean forceRevalidate;
    /** flag to indicate if a sortOrderChanged has happened between pre- and postProcessModelChange. */
    protected boolean filteredRowCountChanged;

    /**
     * Hack around core issue 6791934: sets flags to force revalidate if appropriate.
     * Called before processing the event.
     * @param e the TableModelEvent received from the model
     */
    protected void preprocessModelChange(TableModelEvent e) {
        forceRevalidate = getSortsOnUpdates() && getRowFilter() != null && isUpdate(e) ;
    }

    /**
     * Hack around core issue 6791934: forces a revalidate if appropriate and resets
     * internal flags.
     * Called after processing the event.
     * @param e the TableModelEvent received from the model
     */
    protected void postprocessModelChange(TableModelEvent e) {
        if (forceRevalidate && filteredRowCountChanged) {
            resizeAndRepaint();
        }
        filteredRowCountChanged = false;
        forceRevalidate = false;
    }

    /**
     * Hack around core issue 6791934: sets the sorter changed flag if appropriate.
     * Called after processing the event.
     * @param e the sorter event received from the sorter
     */
    protected void postprocessSorterChanged(RowSorterEvent e) {
        filteredRowCountChanged = false;
        if (forceRevalidate && e.getType() == RowSorterEvent.Type.SORTED) {
            filteredRowCountChanged = e.getPreviousRowCount() != getRowCount();
        }
    }    

//----> end hack around core issue 6791934: