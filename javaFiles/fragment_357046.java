@Override
    public void hide() {
        // If the type is set to one-shot, store that it has shot
        clearBitmap();
        shotStateStore.storeShot();
        mEventListener.onShowcaseViewHide(this);
        fadeOutShowcase();
    }