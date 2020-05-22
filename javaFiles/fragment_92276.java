DefaultCaret c=new DefaultCaret() {
    public void mouseClicked(MouseEvent e) {
        int nclicks = SwingUtilities2.getAdjustedClickCount(getComponent(), e);
        if (! e.isConsumed() &&
                SwingUtilities.isLeftMouseButton(e) &&
                nclicks == 2
                && SwingUtilities2.canEventAccessSystemClipboard(e)) {
            return;
        }

        super.mouseClicked(e);
    }
    public void mousePressed(MouseEvent e) {
        int nclicks = SwingUtilities2.getAdjustedClickCount(getComponent(), e);
        if (! e.isConsumed() &&
                SwingUtilities.isLeftMouseButton(e) &&
                nclicks == 2
                && SwingUtilities2.canEventAccessSystemClipboard(e)) {
            return;
        }
        super.mousePressed(e);
    }
};
c.setBlinkRate(edit.getCaret().getBlinkRate());
edit.setCaret(c);