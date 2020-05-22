// Create a  panel...
panel = new JPanel();
// Create a scroll pane
page = new JTextPane();
// Create a scroll pane with page as the view
JScrollPane scroll = new JScrollPane(page, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
// A little redudent as you did this when you created the scoll pane, but what ever
scroll.setViewportView(page);
// Add the scroll pane to the panel
panel.add(scroll);
// Add the page to this...wait what??!
this.add(page);