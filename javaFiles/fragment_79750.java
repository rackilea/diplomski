Composite right = new Composite( outer, SWT.BORDER );
right.setBackground( display.getSystemColor( SWT.COLOR_YELLOW ) );
FormData rightFormData = new FormData();
rightFormData.top = new FormAttachment( top, 0, SWT.TOP );
rightFormData.left = new FormAttachment( top );
rightFormData.bottom = new FormAttachment( top, 0, SWT.BOTTOM );
right.setLayoutData( rightFormData );