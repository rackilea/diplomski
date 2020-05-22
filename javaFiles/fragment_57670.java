public class ResourcesConfigViewer extends TableViewer{

    public ResourcesConfigViewer(Composite parent,int style) 
    {
        super(parent, style);

        //Get the table and set the headers visible and the lines
        Table table = getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        //Create the columns of the tableviewer
        createColumns(parent);

        //Set the tableviewer contentProvider
        setContentProvider(new ResourcesConfigTableContentProvider());
    }

    /*With this function we create the tableviewer columns and how they will (TextCell) and what they would display*/
    private void createColumns(Composite parent)
    {   
        //Headers of the table
        String[] COLUMN_HEADINGS = {"Table name", "Select"};

        TableColumnLayout tableLayout = new TableColumnLayout();
        parent.setLayout(tableLayout);

        //Set what would display each column
        TableViewerColumn tableName = createTableViewerColumn(COLUMN_HEADINGS[0], 0);
        tableName.getColumn().setResizable(false);
        tableName.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof TableMetaData && element != null)
                    return ((TableMetaData)element).getName();
                return super.getText(element);
            }
        });

        //Set what would display each column
        TableViewerColumn selectCheckBox = createTableViewerColumn(COLUMN_HEADINGS[1], 1);
        selectCheckBox.getColumn().setResizable(false);
        selectCheckBox.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof TableMetaData && element != null){
                    if(((TableMetaData)element).getIsSelected()){
                        return Character.toString((char)0x2611);
                    }else{
                        return Character.toString((char)0x2610);
                    }
                }
                return super.getText(element);
                //return null;
            }

            @Override
            public Image getImage(Object element) {
                /*if(element instanceof TableMetaData && element != null){
                    if(((TableMetaData)element).getIsSelected()){
                        return checked;
                    }else{
                        return unChecked;
                    }
                }
                return super.getImage(element);*/
                return null;
            }
        });



        //Set the dimensions of each column
        tableLayout.setColumnData(selectCheckBox.getColumn(), new ColumnWeightData(10));
        tableLayout.setColumnData(tableName.getColumn(), new ColumnWeightData(90));

        //Set column type (checkbox)
        selectCheckBox.setEditingSupport(new ResourcesConfigCheckEditingSupport(this));
    }

    //Creates the column
    private TableViewerColumn createTableViewerColumn(String header, int idx) 
    {
        //To put checkbox centered in cell.
        int infoLocation = SWT.LEFT;
        if(idx == 1){
            infoLocation = SWT.CENTER;
        }
        TableViewerColumn column = new TableViewerColumn(this, infoLocation, idx);
        column.getColumn().setText(header);
        column.getColumn().setResizable(true);
        column.getColumn().setMoveable(true);

        return column;
    }
}