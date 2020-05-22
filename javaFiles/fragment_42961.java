// code not compiled, run, nor tested in any way
String[] colors = {"Red", "Green", "Blue"};
JRadioButton[] radioBtns = new JRadioButton[colors.length];
for (int i = 0; i < radioBtns.length; i++) {
   radioBtns[i] = new JRadioButton(colors[i]);
   radioBtns[i].setActionCommand(colors[i]);
   radioGroup.add(radioBtns[i]);
   somePanel.add(radioBtns[i]);
}