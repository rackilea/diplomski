ButtonGroup group = new ButtonGroup();
for (int i = 0; i < colorCollection.size(); i++) {
    jrbColor[i] = new JRadioButton(colorCollection.get(i));
    ...
    group.add(jrbColor[i]);
}