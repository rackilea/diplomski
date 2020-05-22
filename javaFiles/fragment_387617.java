//your items
ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
items.add(new OverlayItem("Title", "Description", new GeoPoint(0.0d,0.0d))); // Lat/Lon decimal degrees

//the overlay
ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(
    this, items,  //  <--------- added Context this as first parameter
    new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
    @Override
    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
    //do something
        return true;
    }
    @Override
    public boolean onItemLongPress(final int index, final OverlayItem item) {
        return false;
    }
});  // <----- removed the mResourceProxy parameter
mOverlay.setFocusItemsOnTap(true);

mMapView.getOverlays().add(mOverlay);