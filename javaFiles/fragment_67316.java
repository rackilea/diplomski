JTabbedPane tabPane = new JTabbedPane();
JPanel panel1 = new JPanel();
JPanel panel2 = new JPanel();
JLabel label1 = new JLabel("Tab 1");
JLabel label2 = new JLabel("Tab 2");

panel1.add(label1);
panel2.add(label2);

tabPane.add("Tab 1", panel1);
tabPane.add("Tab 2", panel2);
this.add(tabPane);