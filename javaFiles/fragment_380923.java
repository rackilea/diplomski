c.gridx = 0;
c.gridy = 1;
c.gridwidth = 1;
c.weightx = 1;
this.add(bAdd, c);

c.gridx = 1;
this.add(new JLabel(""), c); //Empty component just for the extra space

c.gridx = 2;
this.add(bMod, c);

c.gridx = 3;
this.add(new JLabel(""), c); //Empty component just for the extra space

c.gridx = 4;
this.add(bDel, c);