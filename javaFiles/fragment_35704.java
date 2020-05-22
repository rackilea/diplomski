// Create the panels
JPanel loginPanel = new JPanel();
JPanel someOtherPanel1 = new JPanel();
JPanel someOtherPanel2 = new JPanel();
JPanel optionPanel = new JPanel();
JPanel someOtherPanel3 = new JPanel();

// Add them to a card layout
JPanel cards = new JPanel(new CardLayout());
cards.add(loginPanel, "loginPanel");
cards.add(someOtherPanel1, "someOtherPanel1");
cards.add(someOtherPanel2, "someOtherPanel2");
cards.add(optionPanel, "optionPanel");
cards.add(someOtherPanel3, "someOtherPanel3");

...

// Switch to the optionPanel
cards.getLayout().show(cards, "optionPanel");