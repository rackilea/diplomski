JPanel north = new JPanel( new BorderLayout() );
north.add(panel, BorderLayout.WEST);
north.add(jtfPanel, BorderLayout.CENTER);

Container contentPane = getContentPane();
contentPane.add(north, BorderLayout.NORTH);
contentPane.add(jtaPanel, BorderLayout.CENTER);
contentPane.add(bPanel, BorderLayout.SOUTH);