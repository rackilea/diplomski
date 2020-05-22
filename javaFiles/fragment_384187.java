listOfItem = new JList();

// create list model 
DefaultListModel<String> listModel = new DefaultListModel<String>();
for (int i = 0; i < car.length; ++i) {
  listModel.addElement(car[i].getId() + ": " + car[i].getDescription() + ", " +
          car[i].getPrice() + ", " + car[i].getQuantity();
}
// register model so that the list shows the data of the model
listOfItem.setModel(listModel);