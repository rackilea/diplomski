jsp.setViewportView(new JComponent() {

    {
        setBackground(Color.red);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 16));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
});