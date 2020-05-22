....
JButton bSave = new JButton("Save");
JButton bPattern = new JButton("New Pattern");
JPanel pContainer = new JPanel();
pContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
pContainer.add(bSave); pContainer.add(bPattern); 
con = new GridBagConstraints();
con.anchor=GridBagConstraints.CENTER;
con.gridy = 3; con.gridx = 0;           
con.gridwidth = 1; con.gridheight = 1;      
m.setConstraints(pContainer, con);
c.add(pContainer);
....