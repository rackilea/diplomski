public class SatellitePlaneProvider implements PlaneProvider {
    public Plane get(Plane planeId) {
        planeIdValidator.validate(planeId);

        // retrieve / create the plane with costly satellite data (using a SatelliteService for example)
        return plane;
    }
}