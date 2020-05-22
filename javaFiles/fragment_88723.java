Node node1 = new Node(this, SWT.NONE, "node 1");
node1.setBounds(25, 25, 50, 50);

Node node2 = new Node(this, SWT.NONE, "node 2");
node2.setBounds(35, 35, 60, 60);
node2.setBackground(new Color(Display.getCurrent(), 75, 75, 75));

// Use moveAbove(null) to move node2 above all its siblings
node2.moveAbove(node1);