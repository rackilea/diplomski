class ResizeListener implements ComponentListener {

    public void componentHidden(ComponentEvent e) {}
    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}

    public void componentResized(ComponentEvent e) {
        Dimension newSize = e.getComponent().getBounds().getSize();          
    }   
}