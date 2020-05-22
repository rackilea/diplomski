public void initTable(ArrayList<Dog> dogList, JTable table) {

  DefaultTableModel model = (DefaultTableModel)table.getModel();
     for(Dog dog : dogList){
          model.addRow(new Object[]{dog.getName(), dog.getColor(), dog.getAge(), ... });
     }
     table.setModel(model);
}