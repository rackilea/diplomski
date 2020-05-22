Composite labelCell = new Composite(shell, SWT.BORDER);
GridData gridData = new GridData();
gridData.heightHint = 250;
gridData.widthHint = 250;
labelCell.setLayoutData(gridData);
labelCell.setLayout(new GridLayout());
Label l = new Label(labelCell , SWT.NONE);
l.setText("some text");
l.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));