ScrolledComposite scrolledComposite = new ScrolledComposite(composite, SWT.H_SCROLL | SWT.V_SCROLL);
// You must set a layout on scrolled composite
scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
scrolledComposite.setExpandHorizontal(true);
scrolledComposite.setExpandVertical(true);

// Additional inner composite is required
Composite innerComposite = new Composite(scrolledComposite, SWT.NONE);
innerComposite.setLayout(new GridLayout());

Group grpModelProperties1 = new Group(innerComposite, SWT.SHADOW_IN);
grpModelProperties1.setLayout(new GridLayout());
grpModelProperties1.setText("Test Model");

GridData data1 = new GridData(SWT.FILL, SWT.TOP, true, false);
data1.heightHint = 400;
data1.widthHint = 400;
grpModelProperties1.setLayoutData(data1);

scrolledComposite.setContent(innerComposite);
// No need to use a resize listener
scrolledComposite.setMinSize(innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));