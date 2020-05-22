JSlider slider = new JSlider();
slider.setUI(new MySliderUI(slider));
...
private static class MySliderUI extends BasicSliderUI {

    public MySliderUI(JSlider b) {
        super(b);
    }

    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle r = trackRect;
        g2d.setPaint(new GradientPaint(
            r.x, r.y, Color.red, r.x + r.width, r.y + r.height, Color.blue));
        g.fillRect(r.x, r.y, r.width, r.height);
    }

    @Override
    public void paintThumb(Graphics g) {
        super.paintThumb(g); // replace with your fill() 
    }
}