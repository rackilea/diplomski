class CursorMouseMotionListener implements MouseMotionListener{

    JFrame yourFrame;

    CursorMouseMotionListener(JFrame yourFrame){
        this.yourFrame = yourFrame;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Do nothing.
    }
    /// The important bit below
    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getPoint().x >= 50 && e.getPoint().x <=150 && e.getPoint().y >= 50 && e.getPoint().y <=150){
            yourFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else{
            yourFrame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }
    }

}