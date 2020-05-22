JLabel label = new JLabel("Option");
label.setAlignmentX(Component.LEFT_ALIGNMENT); // Added

panel.add(label);

JLabel a = new JLabel("A");
JLabel b = new JLabel("B");
JLabel c = new JLabel("C");
JLabel d = new JLabel("D");
JLabel e = new JLabel("E");

Box box = Box.createVerticalBox();
box.add(a);
box.add(b);
box.add(c);
box.add(d);
box.add(e);

JScrollPane jscrlpBox = new JScrollPane(box);
jscrlpBox.setPreferredSize(new Dimension(140, 90));
panel.add(jscrlpBox);
jscrlpBox.setAlignmentX(Component.LEFT_ALIGNMENT); // Added