private javax.swing.Timer overScrollOffTimer;
ActionListener overScrollOffListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == overScrollOffTimer) {
            /* Stop timer */
            overScrollOffTimer.stop();
            overScrollOffTimer = null;

            mymodel.setOverScrollbar(false);
            mymodel.notifyObservers();
            revalidate();
            repaint();
        }
    }
};

private javax.swing.Timer activeScrollOffTimer;
ActionListener activeScrollOffListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == activeScrollOffTimer) {
            /* Stop timer */
            activeScrollOffTimer.stop();
            activeScrollOffTimer = null;

            mymodel.setBeingScrolled(false);
            mymodel.notifyObservers();
            revalidate();
            repaint();
        }
    }
};