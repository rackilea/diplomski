ctv.getTable().addSelectionListener(new SelectionAdapter() {

  @Override
  public void widgetSelected(SelectionEvent e) {
      int df = ctv.getTable().getSelectionIndex();
      ctv.setChecked(ctv.getElementAt(df), !ctv.getChecked(ctv.getElementAt(df)));
  }         
});