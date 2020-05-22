public interface OnCastButtonClickedListener {
    void onCastButtonClicked();
}

public void setCastButtonEnabled(boolean enabled) {
    // Turn it on or off
}

public void setOnCastButtonClickedListener(OnCastButtonClickedListener l) {
    // Assign some listener to delegate the button click to.
}