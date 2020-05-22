JPanel theButtonPanel = new JPanel(new BorderLayout());
JButton button1 = new JButton("Fire");
JButton button2 = new JButton("Pass");
JButton button3 = new JButton("Forfiet");

JPanel innerButtonContainer = new JPanel(new Grid(1, 3, 8, 8));
innerButtonContainer.add(button1);
innerButtonContainer.add(button2);
innerButtonContainer.add(button3);

theButtonPanel.add(innterButtonContainer);