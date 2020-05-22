public void actionPerformed(ActionEvent e) {
    String id = nameList.getSelectedValue().toString(); //valid value when button pressed
    int index = nameList.getSelectedIndex(); //valid value when value pressed

    DefaultListModel listModel = (DefaultListModel) namesList.getModel();
    listModel.removeElementAt(index); 
}