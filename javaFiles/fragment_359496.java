final Button button = new Button(shell, SWT.NONE);
button.setText("Button");

final FormData layoutData = new FormData();

/* Compute the offset */
int offset = -button.computeSize(SWT.DEFAULT, SWT.DEFAULT).y / 2;

/* Create the FormAttachment */
layoutData.top = new FormAttachment(50, offset);
layoutData.left = new FormAttachment(0);
layoutData.right = new FormAttachment(100);
button.setLayoutData(layoutData);