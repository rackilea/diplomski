Text text = new Text(composite, SWT.BORDER);

FieldDecorationRegistry decRegistry = FieldDecorationRegistry.getDefault();

FieldDecoration infoField = decRegistry.getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);

ControlDecoration decoration = new ControlDecoration(text, SWT.TOP | SWT.LEFT);
decoration.setImage(infoField.getImage());

decoration.setDescriptionText("Info decoration text");

GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);

// Space for decoration image
gridData.horizontalIndent = decRegistry.getMaximumDecorationWidth();

text.setLayoutData(gridData);