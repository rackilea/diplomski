JScrollPane scrollPane = new JScrollPane();
JPanel view = new JPanel(new GridLayout(0, 1));
String[] usernames = {"User1", "User2", "User3"};
ButtonGroup group = new ButtonGroup();
this.group = group;

for (String name: usernames) {
    JRadioButton button = new JRadioButton(name);
    button.setActionCommand(name);
    button.addActionListener(this);
    this.group.add(button);
    view.add(button);
}

scrollPane.setViewportView(view);
// Add scrollpane to WEST position of main view