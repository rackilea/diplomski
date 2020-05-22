container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
container.setLayout(new GridLayout(1, false));

Composite questionContainer = new Composite(container, SWT.NONE);
questionContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
questionContainer.setLayout(new FillLayout());

Label question = new Label(questionContainer, SWT.NONE);
question.setText("Please enter the key size of your algorithm");

Composite contentContainer = new Composite(container, SWT.NONE);
contentContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
contentContainer.setLayout(new GridLayout(4, false));

// rest of the content using contentContainer as parent