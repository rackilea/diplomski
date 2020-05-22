class SpeedListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        float speed = model.getSpeed();
        view.setSpeed(speed);
    }
}