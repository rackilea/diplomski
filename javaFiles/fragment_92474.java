JComboBox cbq = (JComboBox)event.getSource();
String itemNumber = (String)cbq.getSelectedItem();
getQuantity(itemNumber);

//this returns the same combobox as above, so probably incorrect behavior
JComboBox cb = (JComboBox)event.getSource();
String name = (String)cb.getSelectedItem();
getItemName(name);