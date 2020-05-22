private JButton b = new JButton() {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(0, 0); // why (0,0) ???
    }
};