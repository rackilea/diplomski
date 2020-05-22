IMapController mapController = map.getController();
 for(int i =0 ; i<overlay.getMyPositionList().size();i++)
 {
     Marker marker = new Marker(map);
     marker.setPosition(overlay.getMyPositionList().get(i));
     map.getOverlays().add(marker);
 }
 mapController.setCenter(overlay.getMyPositionList().get(0));
 map.invalidate();