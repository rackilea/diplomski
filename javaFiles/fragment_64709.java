// create JList w/ model
JList<Employee2> list = new JList<>(listModel);

// .....

// add JList to JScrollpane
JScrollPane scrollPane = new JScrollPane(list);


// .....

// create "wrapper" JPanel 
JPanel container = new JPanel(new BorderLayout());
container.add(scrollPane);  // and place JScrollPane into it
container.setBorder(BorderFactory.createTitledBorder(WEEK_DAYS[i]));

// add wrapper JPanel to the GUI
add(container);