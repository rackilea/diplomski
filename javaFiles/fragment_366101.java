// Obtain the SupportMapFragment and get notified when the map is ready to be used.
    String MAP_FRAGMENT = "map_fragment";

    FragmentManager fragmentManager = getChildFragmentManager();
    SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager
            .findFragmentByTag(MAP_FRAGMENT); // Check if map already exists

    if(mapFragment == null){ 
        // Create new Map instance if it doesn't exist
        mapFragment = SupportMapFragment.newInstance();
        fragmentManager.beginTransaction()
                .replace(R.id.map_container, mapFragment, MAP_FRAGMENT)
                .commit();
    }
    mapFragment.getMapAsync(this);