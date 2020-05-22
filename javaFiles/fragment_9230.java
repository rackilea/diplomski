if (googlemap != null) {
        googlemap.addMarker(marker).showInfoWindow();
    }else {
        intialiseMap();
        googlemap.addMarker(marker).showInfoWindow();
    }