ChangeListener listener = new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        MenuElement[] elements = MenuSelectionManager.defaultManager().getSelectedPath();
        jMenuBar1.setVisible(elements.length > 0 && elements[0] == jMenuBar1);
    }
};
MenuSelectionManager.defaultManager().addChangeListener(listener);