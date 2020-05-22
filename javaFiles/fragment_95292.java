private boolean _hasLoadedOnce= false; // your boolean field

@Override
public void setUserVisibleHint(boolean isFragmentVisible_) {
    super.setUserVisibleHint(true);


    if (this.isVisible()) {
        // we check that the fragment is becoming visible
        if (isFragmentVisible_ && !_hasLoadedOnce) {
            new NetCheck().execute();
            _hasLoadedOnce = true;
        }
    }
}