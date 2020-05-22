for (int i = 0; i < colorCollection.size(); i++) {
    jrbColor[i] = new JRadioButton(colorCollection.get(i));
    ...
    ButtonGroup group = new ButtonGroup();
    group.add(jrbColor[i]);
}