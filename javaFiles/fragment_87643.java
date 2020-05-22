private void createTableViewer(Composite parent) {
  viewer = new AplotDataTableViewer(parent, SWT.BORDER|SWT.V_SCROLL|SWT.FULL_SELECTION);
  final IObservableList iob = AplotDataModel.getInstance().getObservableList();
  viewer.setInput(iob);

  final IListChangeListener listener = new IListChangeListener() {
     @Override
     public void handleListChange(ListChangeEvent event) {
        updateTableViewer();   
     }
  };

  iob.addListChangeListener(listener);

  getShell().addDisposeListener(
    new DisposeListener() {
        @Override public void widgetDisposed(DisposeEvent e) {
            iob.removeListChangeListener(listener);
        }
    });
}