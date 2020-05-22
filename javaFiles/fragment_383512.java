panel.setComponentPopupMenu(getMenu());
panel.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent event) {
        getMenu().show(getPanel(), event.getX(), event.getY());
    }
});