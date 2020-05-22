private static final float MINIMUM_ACCURACY = 10;
private static final float MINIMUM_DISTANCE_BETWEEN_POINTS = 20;
private Location lastLocationloc;

// ...

public void onLocationChanged(Location mylocation) {
    if (mylocation.getAccuracy() < MINIMUM_ACCURACY) {
        if (lastLocationloc == null || lastLocationloc.distanceTo(mylocation) > MINIMUM_DISTANCE_BETWEEN_POINTS) {
            // Add the new location to your polyline

            lastLocationloc = mylocation;
        }
    }
}