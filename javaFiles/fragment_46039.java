protected void createButtonsForButtonBar(Composite parent)
    {
        final GridLayout layout = (GridLayout)parent.getLayout();
        layout.numColumns += 2;
        layout.makeColumnsEqualWidth = false;

        parent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));    

        final Button checkButton = new Button(parent, SWT.CHECK);
        checkButton.setText("View All schedules");
        checkButton.setSelection(false);
        checkButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        // Left out selection code for clarity

        final Label label = new Label(parent, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);

        createButton(parent, IDialogConstants.CANCEL_ID, "Close", false);
    }