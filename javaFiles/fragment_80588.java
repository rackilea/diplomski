JSplitPane splitPane = new JSplitPane();
JPanel leftPanel = new JPanel();
JPanel rightPanel = new JPanel();
JLabel label1 = new JLabel();
JLabel label2 = new JLabel();
JTextField textField = new JTextField();
GridBagConstraints gBC = new GridBagConstraints();

getContentPane().setLayout(new GridBagLayout());
leftPanel.setLayout(new GridBagLayout());
rightPanel.setLayout(new GridBagLayout());

// I'm not going to bother doing any layout of the label or textfield here
leftPanel.add(label1, new GridBagConstraints());
leftPanel.add(label2, new GridBagConstraints());
rightPanel.add(textField, new GridBagConstraints());

splitPane.setLeftComponent(leftPanel);
splitPane.setRightComponent(rightPanel);

gBC.fill = GridBagConstraints.BOTH;
gBC.weightx = 1.0;
gBC.weighty = 1.0;
getContentPane().add(splitPane, gBC);

pack();