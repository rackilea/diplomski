scrollT = new JScrollPane(topPanel);  // topPanel added to scroll pane
scrollT.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
scrollB = new JScrollPane(botPanel);  // botPanel added to scroll pane
scrollB.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
menupanel.add(scrollT); // scrollpanes added to menupanel -- without Borderlayout constants?
menupanel.add(scrollB);

menupanel.add( topPanel, BorderLayout.NORTH );  // topPanel added to menupanel
menupanel.add( botPanel, BorderLayout.SOUTH );