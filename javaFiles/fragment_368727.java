shell.setLayout(new GridLayout(3, false));

Label title = new Label(shell, SWT.NONE);
title.setText("My first text editor");
GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
data.horizontalSpan = 3;
title.setLayoutData(data);

Label select = new Label(shell, SWT.NONE);
select.setText("Select a file:");
data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
select.setLayoutData(data);

Text text = new Text(shell, SWT.BORDER);
data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
text.setLayoutData(data);

Button button = new Button(shell, SWT.PUSH);
button.setText("Browse...");
data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
button.setLayoutData(data);

List result = new List(shell, SWT.BORDER);
data = new GridData(SWT.FILL, SWT.FILL, true, true);
data.horizontalSpan = 3;
result.setLayoutData(data);