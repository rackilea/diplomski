JPanel somethingHere = ...;
JPanel chat = ...;
JPanel userList = ...;

JPanel leftPanel = new JPanel( new BorderLayout() );
leftPanel.add( somethingHere, BorderLayout.CENTER );
leftPanel.add( chat, BorderLayout.SOUTH );

JPanel total = new JPanel( new BorderLayout() );
total.add( leftPanel, BorderLayout.CENTER );
total.add( userList, BorderLayout.EAST );