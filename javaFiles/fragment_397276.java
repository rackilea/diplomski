Label lbl1 = new Label(container, SWT.NONE);
GridData lbl1griddata = new GridData(SWT.CENTER, SWT.CENTER, false, false);
lbl1.setLayoutData(lbl1griddata);
lbl1.setText("This is a short text. Shorter than the other.");

GC gc = new GC(lbl1.getDisplay());
int width = gc.textExtent(lbl1.getText()).x;
gc.dispose();

Label lbl2 = new Label(container, SWT.WRAP);
GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
data.widthHint = width;
lbl2.setLayoutData(data);
lbl2.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.");