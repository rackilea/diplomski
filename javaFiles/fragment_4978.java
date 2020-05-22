ActionListener[] actionListeners = tester.comboBox2.getActionListeners();
for (ActionListener actionListener : actionListeners) {
    tester.comboBox2.removeActionListener(actionListener);
}
tester.comboBox2.removeAllItems();
String flowerChoice = tester.comboBox1.getSelectedItem().toString();
if (flowerChoice.equalsIgnoreCase("Rose"))
    for (String colorPicked : color1) {
        tester.comboBox2.addItem(colorPicked);
    }
else {
    for (String type : color2) {
        tester.comboBox2.addItem(type);
    }
}
for (ActionListener actionListener : actionListeners) {
    tester.comboBox2.addActionListener(actionListener);
}