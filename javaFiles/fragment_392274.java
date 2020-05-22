private JPanel panel;

private void createPanelOne() {
    panel = new JPanel(new FlowLayout());
    ...
    add(panel);
}

private void createPanelTwo() {
    panel = new JPanel(new GridBagLayout());
    ...
    add(panel);
}