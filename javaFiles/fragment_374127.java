class BackgroundImagePanel extends JPanel {

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, this);
    }

    private Image backgroundImage;
}

BackgroundImagePanel panel = new BackgroundImagePanel();
panel.setBackgroundImage(image);
panel.add(new JTextField("Enter text here..."));
panel.add(new JButton("Press Me"));