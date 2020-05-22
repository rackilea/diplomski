JList list = new JList(); // You need to create the JList first
JScrollPane scrollPane = new JScrollPane(list);
// Add the scrollpane to the UI

...

// At some time in the future, load the results...
DefaultListModel model = new DefaultListModel();
while (src.hasNext()) {
    String lol = src.nextLine();
    model.addElement(lol);
}
list.setModel(model);