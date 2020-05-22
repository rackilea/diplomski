JComboBox<String> box = new JComboBox<>();
final Color bg = box.getBackground();
box.setUI(new BasicComboBoxUI() {
    @Override
    protected JButton createArrowButton() {
        JButton b = super.createArrowButton();
        b.setBackground(bg);
        b.setBorderPainted(false);
        return b; 
   }
});