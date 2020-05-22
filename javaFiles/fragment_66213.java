JTextField textField;
JMenuBar menuBar = new JMenuBar();
setJMenuBar(menuBar);

JMenu fileMenu = new JMenu("File");
menuBar.add(fileMenu);

JMenuItem menuItem1 = new JMenuItem("Menu Item above");
fileMenu.add(menuItem1);

JSeparator separatorAbove = new JSeparator();
fileMenu.add(separatorAbove);
JPanel panel = new JPanel();
fileMenu.add(panel);

textField = new JTextField();
panel.add(textField);
textField.setColumns(10);

JButton button = new JButton("New button");
panel.add(button);

JSeparator separatorBelow = new JSeparator();
fileMenu.add(separatorBelow);

JMenuItem menuItem2 = new JMenuItem("Menu Item below");
fileMenu.add(menuItem2);