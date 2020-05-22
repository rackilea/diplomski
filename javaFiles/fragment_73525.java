int mapType =  GoogleMap.MAP_TYPE_SATELLITE;

FragmentManager manager = getSupportFragmentManager();
SupportMapFragment mapFragment = (SupportMapFragment) manager.findFragmentById(R.id.map);
map = mapFragment.getMap();
map.setMapType(mapType);