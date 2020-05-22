col.setLabelProvider(new ColumnLabelProvider() {
  @Override
  public void update(ViewerCell cell) {
     TableItem item = (TableItem) cell.getItem();

     Composite buttonPane = new Composite(getTable(), SWT.NONE);
     buttonPane.setLayout(new FillLayout());

     Button button = new Button(buttonPane,SWT.NONE);
     button.setText("Edit");

     button = new Button(buttonPane,SWT.NONE);
     button.setText("Remove");

     button = new Button(buttonPane,SWT.NONE);
     button.setText("Deactivate");

     TableEditor editor = new TableEditor(getTable());
     editor.grabHorizontal  = true;
     editor.grabVertical = true;
     editor.setEditor(buttonPane, item, columnIndex);
     editor.layout();
     }
  });