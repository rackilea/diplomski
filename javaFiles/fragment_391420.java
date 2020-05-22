void myLocationBottomLeftAlign() {
    try {
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);

        final ViewGroup parent = (ViewGroup) mMapFragment.getView().findViewWithTag("GoogleMapMyLocationButton").getParent();
        parent.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Resources r = getResources();
                    int marginPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, r.getDisplayMetrics());

                    View mapLocation = mMapFragment.getView().findViewWithTag("GoogleMapMyLocationButton");

                    // create layoutParams, giving it our wanted width and height(important, by default the width is "match parent")
                    RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(mapLocation.getHeight(),
                            mapLocation.getHeight());
                    // position on top right
                    rlp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
                    rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
                    rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    //give compass margin
                    rlp.setMargins(marginPixels, marginPixels, marginPixels, marginPixels);
                    mapLocation.setLayoutParams(rlp);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}