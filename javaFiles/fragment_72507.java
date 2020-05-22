String[] items = { "one", "two", "three" };
SortedComboBoxModel<String> model = new SortedComboBoxModel<String>(items);
JComboBox<String> comboBox = new JComboBox<String>(model);
comboBox.addItem("four");
comboBox.addItem("five");
comboBox.setSelectedItem("one");