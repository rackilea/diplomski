@Override
public void updateBuffer(final Graphics g,final Dimension offscreenSize) {
    if(areLabelsBeingScrolled()) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p,getComponent());
        debug("Cursor x coordinate relative to column labels: [" + p.x + "]",8);
        int hDI = map.getIndex(p.x); //Hover Data Index
        if(hDI > map.getMaxIndex()) {
            hDI = map.getMaxIndex();
        } else if (hDI < 0) {
            hDI = 0;
        }
        map.setHoverIndex(hDI);
    }
    super.updateBuffer(g,offscreenSize);
}