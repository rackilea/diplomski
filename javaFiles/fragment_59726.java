public static void main(String[] args) {
    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.addItem("item1");
    comboBox.addItem("item2");

    JLabel label = new JLabel();

    comboBox.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            label.setText("selected item: " + comboBox.getSelectedItem());
        }
    });

    JPanel panel = new JPanel();
    panel.add(label);
    panel.add(comboBox);

    JFrame frame = new JFrame();
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
}