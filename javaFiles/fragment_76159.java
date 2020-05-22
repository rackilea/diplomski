@Override
public void widgetSelected(SelectionEvent e) {
    try {
        MarshallingUnmarshalling.marshaling();
        // or MarshallingUnmarshalling.unMarshaling();
     } catch (JAXBException e) {
         showError(e);
     }
}

private void showError(Exception e) {
    final Text text = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
    text.setText("An error occurred!");
    text.setLayoutData(new GridData(GridData.FILL_BOTH));
    Status status = new Status(IStatus.ERROR, "Plug-in ID", 0,
        "Status Error Message", e);

    ErrorDialog.openError(Display.getCurrent().getActiveShell(),
        "Error!", text.getText(), status);
}