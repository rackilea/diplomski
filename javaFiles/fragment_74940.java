ListBox list = new ListBox();
list.addItem("John Smith", 1);
list.addItem("Jane Doe", 2);

int index = list.getSelectedIndex(); /// assuming selected index is zero for example
list.getValue(index); // ----> returns "John Smith"
list.getItemText(index); // ------> returns "1"