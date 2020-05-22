menu = new JPopupMenu() {
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            getField().requestFocus();
        }
    }
};