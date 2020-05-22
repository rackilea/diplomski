@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleGeoCodeResponse {

private String status;
private GeocodedWaypoint[] geocodedWaypoints;
private Route[] routes;

...