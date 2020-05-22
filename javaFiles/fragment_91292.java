private static final Timer TICK_HOUR = new Timer(3600000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        TICK_HOUR.getActionListeners()[0].actionPerformed(null);
    }
});