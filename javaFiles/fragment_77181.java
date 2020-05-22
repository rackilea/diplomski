bar.setHidden(true);
ChangeListener listener = new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        MenuElement[] elements = MenuSelectionManager.defaultManager().getSelectedPath();
        bar.setHidden(!(elements.length >0 && elements[0] == bar));
    }
};
MenuSelectionManager.defaultManager().addChangeListener(listener);