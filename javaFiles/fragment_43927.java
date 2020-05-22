class PopupListener extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent e) {
        popit(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        popit(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        popit(e);
    }

    private void popit(MouseEvent e) {
        if (e.isPopupTrigger()) {
            pop.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}