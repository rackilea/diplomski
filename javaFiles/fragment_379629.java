example1.Ground g = new SomeGround();
// ground object
javax.swing.JFrame window = new javax.swing.JFrame("windowwithbutton");
//window (JFRAME)
javax.swing.JPanel panel = new javax.swing.JPanel();
//content (JPANEL)
javax.swing.JButton ab = new javax.swing.JButton("add");
ab.addActionListener(new EventHandler(g));