AbstractAction action = new AbstractAction() {

    @Override
    public void actionPerformed(ActionEvent e) {
        Point mLoc = MouseInfo.getPointerInfo().getLocation();
        Rectangle bounds = frame.getBounds();

        // Test to make sure the mouse is inside the window
        if(bounds.contains(mLoc)){
            Point winLoc = bounds.getLocation();
            mouseLoc = new Point(mLoc.x - winLoc.x, mLoc.y - winLoc.y);
        }

    }
};