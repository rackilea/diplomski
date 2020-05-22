Composite body = new Composite(parent, SWT.NONE);

body.setLayout(new GridLayout(2, false));

Label label = new Label(body, SWT.LEFT);
label.setText("I need the complete ECR/ECN Process:");

Button checkFullECR = new Button(body, SWT.CHECK);

... more label / button pairs ....