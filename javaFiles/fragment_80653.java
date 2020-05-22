@Override
    public void onSelection(SelectionEvent<Item> event) 
    {
           ....

           double lockedTableWidth = 0;//calculate

           lockedColumnLayoutData.setWidth(lockedTableWidth);   

           gridWrapper.forceLayout();
     }