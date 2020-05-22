class RightClickListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent mev) {           
        p = (Place) mev.getSource();

        if (mev.getModifiers() == InputEvent.BUTTON3_MASK) {
            p.action();
        }
    }
}