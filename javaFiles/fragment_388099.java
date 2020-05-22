String[] numbers = {"1","2","3","4","5","6","7","8","9","10"};
JPanel myGridLayoutUsingJPanel = new JPanel(new GridLayout(0, 1));
JComboBox[] combos = new JComboBox[MAX_COMBOS]; // MAX_... is a constant
for (int i = 0; i < combos.length; i++) {
  combos[i] = new JComboBox(numbers);
  combos[i].addActionListener(someActionListener);
  myGridLayoutUsingJPanel.add(combos[i]);
}

// add myGridLayoutUsingJPanel to the GUI...