//JLabel labelSemester = new JLabel("Semester 1: ",SwingConstants.LEFT);
JLabel labelSemester = new JLabel("Semester 1: ");
label.semester.setAlignmentX(JLabel.LEFT_ALIGNMENT);
panel.add(labelSemester);

...

JTable table = new JTable(table_rows, col_names);
//panel.add(new JScrollPane(table));
JScrollPane scrollPane = new JScrollPane( table );
scrollPane.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
panel.add( scrollPane );