scroll.setVerticalScrollbar(new JScrollBar() {
    public void setValue(int value) {
        new Exception().printStackTrace();
        super.setValue(value);
    } 
});