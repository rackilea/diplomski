table.addFocusListener(new FocusAdapter() {
    @Override
    public void focusLost(FocusEvent e) {
        if (e.getOppositeComponent().getParent() != table) {
            loseCellFocus();
        }
    }
});