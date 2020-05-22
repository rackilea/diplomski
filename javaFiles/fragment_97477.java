north = new JPanel();
north.setLayout(new BorderLayout());
ip = new JButton ("New");
ip.setPreferredSize(new Dimension(100,50));
print = new JButton ("Print");
north.add(ip, BorderLayout.WEST);

JPanel centerPanel = new JPanel();
centerPanel.add(print);
centerPanel.add(new JLabel("Time Step (in s): "));
timeStep = new JTextArea("10",1,5);
centerPanel.add(timeStep);
start = new JButton("OK");
centerPanel.add(start);

north.add(centerPanel, BorderLayout.CENTER);