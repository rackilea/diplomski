table = new DynamicTable(shell, SWT.BORDER | SWT.FULL_SELECTION);        
    table.addMenuDetectListener(new MenuDetectListener()
    {
        @Override
        public void menuDetected(MenuDetectEvent e)
        {                
           int index = table.getSelectionIndex();
           if (index == -1) 
             return; //no row selected

           TableItem item = table.getItem(index);
           item.getData(); //use this to identify which row was clicked.
           //The popup can now be displayed as usual using table.toDisplay(e.x, e.y)              
        }
    });