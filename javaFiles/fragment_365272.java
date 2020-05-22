myText.addMouseWheelListener(new MouseWheelListener() {
    @Override
    public void mouseScrolled(MouseEvent e) {
        if (!myText.isFocusControl() ) {
            myText.getVerticalBar().setEnabled(false);
            if (e.count == 3) {
                mySc.setOrigin(sc.getOrigin().x, mySc.getOrigin().y - 30);
            } else if (e.count == -3) {
                mySc.setOrigin(sc.getOrigin().x, mySc.getOrigin().y + 30);
            }
        } else {
            myText.getVerticalBar().setEnabled(true);
        }
    }
});