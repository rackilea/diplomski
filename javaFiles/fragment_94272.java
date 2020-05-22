Create Map varible as activity field.And define variable in onMapReady function.After that use activity variable as you want. I think it should works.

GoogleMap map;

public void onMapReady(GoogleMap map) {

    this.map = map;
    map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    map.getUiSettings().setMapToolbarEnabled(true);
}