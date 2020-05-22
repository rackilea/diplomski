JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(BoxLayout.Y_AXIS, panel));
List<JCheckBox> checkboxes = new ArrayList<>();

for(String element : myArrayList) {
    JCheckBox box = new JCheckBox(element);
    checkboxes.add(box);
    panel.add(box);
}

frame.add(panel);