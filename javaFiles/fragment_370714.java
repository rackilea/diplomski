class ListItem extends JComponent{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JCheckBox checkbox;
    JLabel label;
    JButton removeBtn;

    public ListItem(String label) {
        setLayout(new BorderLayout());
        this.label = new JLabel();
        this.label.setText(label);

        this.checkbox = new JCheckBox();

        this.removeBtn = new JButton();
        removeBtn.setText("Remove");
        add(checkbox, BorderLayout.WEST);
        add(this.label);
        add(removeBtn, BorderLayout.EAST);
    }
}