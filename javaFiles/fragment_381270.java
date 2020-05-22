column.addSelectionListener(new SelectionListener(){

        @Override
        public void widgetSelected(SelectionEvent e) 
        {
            int column = ((GridColumn) e.item).getCellRenderer().getColumn();
            tableViewer.getGrid().selectColumn(column);
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) { }

    });