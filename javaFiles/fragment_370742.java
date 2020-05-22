if (item instanceof JTextField) {
    ((JTextField) item).setText(null);
}
else {
    ((JComboBox) item).setSelectedIndex(-1);
}