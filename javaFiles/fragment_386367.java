CDStore store = new CDStore("Store");
// add some CDs

JList listOfCD = new JList(store);
listOfCD.setVisibleRowCount(4);
JScrollPane listPane = new JScrollPane(listOfCD);
JTextField valueField = new JTextField("None", 7);