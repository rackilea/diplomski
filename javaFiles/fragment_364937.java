ColumnConfig cfg = new ColumnConfig();
cfg.setRenderer(new GridCellRenderer() {
    @Override
    public Object render(M model, String property,
                    ColumnData config, int rowIndex, int colIndex,
                    ListStore<M> store, Grid<M> grid) { 
        Button button = new Button();
        // set up button based on params to this render function
        // for example, the `model` argument is the item backing each row.
        // this render method is called for each row in the grid
        // see http://dev.sencha.com/deploy/gxt-2.2.5/docs/api/com/extjs/gxt/ui/client/widget/grid/GridCellRenderer.html
        return button;
    }
}):