myCustomJPanel = new MyCustonJPanel();
GrabbableViewport v = new GrabbableViewport();
v.setView(myCustomJPanel);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setViewport(v);
enclosingContainer.add(scrollPane);