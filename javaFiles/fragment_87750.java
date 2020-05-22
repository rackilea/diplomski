Label filler = new Label(composite, SWT.LEAD);
filler.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

GridData gridData2 = new GridData(SWT.END, SWT.END, false, false);
gridData2.widthHint = 80;

Button buttonOk = new Button(composite, SWT.PUSH | SWT.CENTER);
buttonOk.setText("OK");
buttonOk.setLayoutData(gridData2);

gridData2 = new GridData(SWT.END, SWT.END, false, false);
gridData2.widthHint = 80;

Button buttonCancel = new Button(composite, SWT.PUSH | SWT.CENTER);
buttonCancel.setText("Cancel");
buttonCancel.setLayoutData(gridData2);

gridData2 = new GridData(SWT.END, SWT.END, false, false);
gridData2.widthHint = 80;

Button buttonHelp = new Button(composite, SWT.PUSH | SWT.CENTER);
buttonHelp.setText("Help");
buttonHelp.setLayoutData(gridData2);