/*The following only loads the last item in the list which is Oranges.*/

for(Item i: list)
{
      comboBox.setModel(new DefaultComboBoxModel(new String[] { 
      i.getName()})); 
}