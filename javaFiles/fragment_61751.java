private JButton makeButton(String text) {
    JButton b = new JButton(text);
    b.setHorizontalAlignment(SwingConstants.LEFT);
    b.addActionListener(this);
    b.setPreferredSize(new Dimension(125, 55)); //set preferred and let Layout manager do its work
    return b;
}