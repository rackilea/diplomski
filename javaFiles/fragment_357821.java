MouseAdapter ma = new MouseAdapter() {
    //...
    @Override
    public void mouseEntered(MouseEvent e) {
        if (isAutoDisplayEnabled) {
        popup.setVisible(true);
        }
    }