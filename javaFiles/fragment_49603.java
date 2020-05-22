addMouseMotionListener(new MouseMotionListener() {
    private int mx, my;

    @Override
    public void mouseMoved(MouseEvent e) {
        mx = e.getXOnScreen();
        my = e.getYOnScreen();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = StatisticsMainFrame.this.getLocation();
        p.x += e.getXOnScreen() - mx;
        p.y += e.getYOnScreen() - my;
        mx = e.getXOnScreen();
        my = e.getYOnScreen();
        StatisticsMainFrame.this.setLocation(p);
    }
});