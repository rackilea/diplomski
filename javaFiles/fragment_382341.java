FileDialog fd = new FileDialog(shell, SWT.OPEN);
fd.setText("Open file");
fd.setFilterPath("C:/");
String[] filterExt = { "*.txt", "*.doc", ".rtf", "*.*" };
fd.setFilterExtensions(filterExt);
String file= fd.open();
System.out.println(file);