String [] elements = ...

ListSelectionDialog dialog = 
   new ListSelectionDialog(shell, elements, ArrayContentProvider.getInstance(),
            new LabelProvider(), "selection message");

dialog.setTitle("dialog title");

dialog.setInitialSelections(new Object []{....selections});

dialog.open();

Object [] result = dialog.getResult();