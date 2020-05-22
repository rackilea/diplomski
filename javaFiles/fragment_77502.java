getContentPane().setLayout(new GridBagLayout()); // Set the layout on the content pane rather than the JFrame

gridbBagConstraints = new GridBagConstraints();
gridbBagConstraints.insets = new Insets(10, 0, 10, 0);
gridbBagConstraints.ipady = 10;
gridbBagConstraints.ipadx = 10;

drugDetailsTable = new JTable(drugDetailsTabelModel);
drugDetailsTable.setPreferredScrollableViewportSize(new Dimension(600, 100));
drugDetailsTable.setFillsViewportHeight(true);

JScrollPane scrollPane = new JScrollPane(drugDetailsTable);
scrollPane.setBounds(5, 218, 884, 194);

getContentPane().add(scrollPane); // Add the scroll pane to the content pane rather than the JFrame

pack(); // Call pack at the end