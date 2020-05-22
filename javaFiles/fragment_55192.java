class ModelListener implements PropertyChangeListener {
    private ShowCount showCount;

    public ModelListener(ShowCount showCount) {
        super();
        this.showCount = showCount;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int newValue = (int) evt.getNewValue();
        showCount.setCountLabelText(String.format("%03d", newValue));
    }
}