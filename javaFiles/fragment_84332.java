panel = new JPanel();
Container pane = mainWindow.getContentPane();
GroupLayout gl = new GroupLayout(pane);
pane.setLayout(gl);
gl.setAutoCreateContainerGaps(false);
gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(panel));
gl.setVerticalGroup(gl.createSequentialGroup().addComponent(panel));
// ++++++++++++  editing start
// force do layout subcomponents and rendering
mainWindow.pack();
// ++++++++++++  editing end
System.out.println("w:" + panel.getWidth() + " h:" + panel.getHeight());