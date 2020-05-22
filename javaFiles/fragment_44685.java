@Override
    public void setUserVisibleHint(boolean visible) {
        super.setUserVisibleHint(visible);
        if (visible) {
            Log.i("Tag", "reloading fragment");
        }
    }