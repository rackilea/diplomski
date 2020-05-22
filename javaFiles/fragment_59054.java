JPopupMenu popupMenu = new JPopupMenu();

JMenu deviceMenu = new JMenu("Add Device");
deviceMenu.add(new JMenuItem("Add More..."));

popupMenu.add(deviceMenu);
popupMenu.add(new JMenuItem("Delete Device"));
popupMenu.add(new JMenuItem("Fire"));
popupMenu.add(new JMenuItem("Fault"));
popupMenu.add(new JMenuItem("Supress"));