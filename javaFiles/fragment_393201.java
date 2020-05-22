JComboBox Host1Dropdown = new JComboBox();
Host1Dropdown.setModel(new DefaultComboBoxModel(new String[] {"item1", "item2"});
DefaultComboBoxModel model = (DefaultComboBoxModel)Host1Dropdown.getModel();
model.addElement("item3");
model.removeElement("item1");
model.removeAllElements();