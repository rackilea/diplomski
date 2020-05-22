List<TileOverlay> tileOverlays = new ArrayList<TileOverlay>
tileOverlays.add(mMap.addTileOverlay(tileProvider.overlayOptions));

// ...

for (TileOverlay tileOverlay : tileOverlays) {
    tileOverlay.setVisible(false);
}