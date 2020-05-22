class BackgroundRenderer extends JLabel implements ListCellRenderer<String> {
    private final Image image;

    public BackgroundRenderer(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);

        super.paintComponent(g);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
            boolean isSelected, boolean cellHasFocus) {
        setText(value);

        return this;
    }
}