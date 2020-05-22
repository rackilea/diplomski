JButton loadButton = new JButton("load");
JButton saveButton = new JButton("save");
JPanel panel = new JPanel();
panel.add(loadButton);
panel.add(saveButton);
for (Component component : panel.getComponents()) {
    // ...
}