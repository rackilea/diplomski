private PropertyChangeSupport mPcs =
    new PropertyChangeSupport(this);

public void setMouthWidth(int mw) {
    int oldMouthWidth = mMouthWidth;
    mMouthWidth = mw;
    mPcs.firePropertyChange("mouthWidth", oldMouthWidth, mw); //the modification is "published"
}

public void
addPropertyChangeListener(PropertyChangeListener listener) {
    mPcs.addPropertyChangeListener(listener);
}

public void
removePropertyChangeListener(PropertyChangeListener listener) {
    mPcs.removePropertyChangeListener(listener);
}