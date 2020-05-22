ScrolledForm scrldfrm = managedForm.getForm();

scrldfrm.getBody().setLayout(new GridLayout());

scrldfrm.setText("Hello there!");

Section section = managedForm.getToolkit().createSection(
        managedForm.getForm().getBody(),
        Section.TWISTIE | Section.TITLE_BAR);

section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

managedForm.getToolkit().paintBordersFor(section);
section.setText("Selected API");
section.setExpanded(true);

textName = new Text(managedForm.getForm().getBody(), SWT.BORDER);

textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false);

managedForm.getToolkit().adapt(textName, true, true);
textName.setEnabled(false);