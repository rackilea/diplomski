panel.setLayout(new MigLayout("fill"));
panel.add(new JButton("1"), "dock east, width 120");
panel.add(new JButton("2"), "west");
panel.add(new JButton("3"), "center, grow");
panel.add(new JButton("4"), "north");
panel.add(new JButton("5"), "south");