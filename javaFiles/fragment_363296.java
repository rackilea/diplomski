JPanel panel = new JPanel() {
    @Override       
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
};