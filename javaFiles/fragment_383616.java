DefaultListModel<String> listModel = new DefaultListModel<String>();
JList<String> list = new JList<String>(listModel);
JScrollPane scroll = new JScrollPane(list);
someComponent.add(scroll);

listModel.addElement("new");
listModel.remove(0);