ImageIcon imageIcon = new ImageIcon("src\\SwingExp\\img\\map.gif");
JLabel map = new JLabel( imageIcon );
JScrollPane scrollPane = new JScrollPane( map );
//JScrollPane scrollPane = new JScrollPane(new JLabel(imageIcon));
scrollPane.setBounds(5,5,600,400);
JLabel usaLabel = new JLabel("U.S.A.");
usaLabel.setBounds(210,200,50,25);
map.add( usaLabel );
//mapPanel.add(usaLabel);