JPanel formPanel = new JPanel();

//Adding scroll pane here - to formPanel which holds everything.
JScrollPane scrollPane = new JScrollPane(formPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

...

mainCon.add(scrollPane);
mainCon.add(formPanel);