// Create scroll area.
final Composite scrollArea = new Composite(scrollContainer, SWT.NONE);
scrollArea.setLayout(new GridLayout());

// Setup scrolling.
scrollContainer.setExpandHorizontal(true);
scrollContainer.setExpandVertical(true);

// Create paragraph.
final Label paragraph = new Label(scrollArea, SWT.WRAP);
paragraph.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

// Layout data for label, width a bit smaller than the shell
final GridData data = new GridData(SWT.LEAD, SWT.TOP, false, false);
data.widthHint = shell.getSize().x - 10;
paragraph.setLayoutData(data);

// Can do compute size immediately
final Point size = scrollArea.computeSize(SWT.DEFAULT, SWT.DEFAULT);
scrollContainer.setMinSize(size);
System.out.println("Size: " + size.x + "x" + size.y);

scrollContainer.setContent(scrollArea);