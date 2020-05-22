public class PlaneLocator {
    private CompanyProvider companyProvider;
    private PlaneProvider companyProvider;
    private LocationUtil locationUtil;

    // Constructor injection or property injection

    public Double getDistanceBetweenPlanes(String companyId, String plane1Id, String plane2Id) {
        Company company = companyProvider.get(company);
        Plane plane1 = planeProvider.get(plane1Id);
        Plane plane1 = planeProvider.get(plane1Id);

        return locationUtil.distance(plane1.geoLocation(), plane2.geoLocation());
    }
}