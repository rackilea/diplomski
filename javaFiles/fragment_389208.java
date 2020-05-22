DefaultListModel<String> listModel = new DefaultListModel<>();
  JList<String> infoList = new JList<>(listModel);

  infoList.setVisibleRowCount(20);

  listModel.addElement("oi oi oi oi oi oio i\noioioioioi");
  listModel.addElement("uhuuul");
  listModel.addElement("uhuuul");
  for (int i = 0; i < 100; i++) {
     listModel.addElement("uhuuul");
  }
  listModel.addElement("fim");

  JScrollPane scrollPane = new JScrollPane(infoList);
  scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

  add(scrollPane);