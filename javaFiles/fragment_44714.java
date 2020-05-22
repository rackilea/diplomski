// Initialize GUI elements first:
BuildTopPanel();
BuildBotPanel();
BuildRightPanel();
BuildMainPanel();
// Then add the GUI elements to the window:
getContentPane().add(topPanel, BorderLayout.NORTH);
getContentPane().add(bottomPanel, BorderLayout.SOUTH);
getContentPane().add(rightPanel, BorderLayout.EAST);
getContentPane().add(mainPanel, BorderLayout.WEST);