Label lblText = new Label(contentComposite, SWT.WRAP | SWT.CENTER);

GridData data = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
data.widthHint = 100;  // Maximum width here
lblText.setLayoutData(data);

lblText.setText(message);