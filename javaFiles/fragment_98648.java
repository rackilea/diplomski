JPanel panel = new JPanel(new MigLayout(
        "debug",
        "[][grow, fill][]",
        ""));
JButton comp1 = new JButton("Comp1");
JButton comp2 = new JButton("Comp2");
JButton comp3 = new JButton("Comp3");

panel.add(comp1, "width 50:150:150");
panel.add(comp2); 
panel.add(comp3, "width 50:70:70");