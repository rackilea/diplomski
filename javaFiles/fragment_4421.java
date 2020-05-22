ListModel model = list1.getModel();
DefaultListModel list2Model = new DefaultListModel();
for (int i=0; i<model.getSize(); i++) {
  list2Model.addElement(model.elementAt(i);
}

list2.setModel(list2Model);