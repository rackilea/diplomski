class mypainter implements Painter<JComponent> {

    private Color color=null;

    public mypainter(Color c) {
        color = c;
    }

    @Override
    public void paint(Graphics2D g, JComponent object, int width, int height) {
        g.setColor(color);
        g.fillRect(0, 0, width, height);
    }

}