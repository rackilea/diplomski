private LatLngBounds findBounds(List<LatLng> positions, LatLng center) {
    // Add all the positions to a LatLngBounds (including center)
    LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
    for (LatLng position : positions) {
        boundsBuilder.include(position);
    }
    boundsBuilder.include(center);
    LatLngBounds bounds = boundsBuilder.build();

    // Compute the farthest location from the center among the bound corners
    LatLng northWest = new LatLng(bounds.northeast.latitude, bounds.southwest.longitude);
    LatLng southEast = new LatLng(bounds.southwest.latitude, bounds.northeast.longitude);
    LatLng farthest = findFarthestLocation(center, bounds.northeast, northWest, southEast, bounds.southwest);

    // Expand the bounds adding the projection of the farthest location from the center
    // in the oposite direction
    bounds = bounds.including(SphericalUtil.computeOffset(center,
            SphericalUtil.computeDistanceBetween(center, farthest),
            SphericalUtil.computeHeading(center, farthest) + 180));

    return bounds;
}

private LatLng findFarthestLocation(LatLng from, LatLng... locations) {
    LatLng farthest = null;

    for (LatLng location : locations) {
        if (farthest == null ||
                SphericalUtil.computeDistanceBetween(from, location) > SphericalUtil.computeDistanceBetween(from, farthest)) {
            farthest = location;
        }
    }

    return farthest;
}