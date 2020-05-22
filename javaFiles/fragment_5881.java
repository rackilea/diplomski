Composite buttComposite = toolkit.createComposite(client, SWT.NONE);
buttComposite.setLayout(new GridLayout());
buttComposite.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));

Button button1 = toolkit.createButton(buttComposite, "Button 1", SWT.PUSH); 
gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
button1.setLayoutData(gd);
Button button2 = toolkit.createButton(buttComposite, "Button 2", SWT.PUSH); 
gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
button2.setLayoutData(gd);