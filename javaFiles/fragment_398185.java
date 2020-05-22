JMenu menu = new JMenu("Menu");

JMenuItem item = new JMenuItem("Add");
item.add(new JButton("SOMETHING A BIT WORDY"));
item.setLayout(new FlowLayout()); // set FlowLayout for item
item.setPreferredSize(new Dimension(200, 100)); // hard code implementation :-(
menu.add(item);

// ... 
JMenuBar menuBar = new JMenuBar();
menuBar.add(menu);
JFrame frame = new JFrame();
frame.setJMenuBar(menuBar);

// ...
frame.pack();
frame.setVisible(true);