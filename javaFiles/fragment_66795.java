JPanel panel = new JPanel(new GridLayout(3, 3));
for (int i = 1; i <= 9; i++) {
    JButton button = new JButton("Button " + i);
    panel.add(button);

    // save it to a map for easy retrieval
    buttonMap.put(button.getText(), button);
}