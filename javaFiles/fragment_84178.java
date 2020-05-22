public final class LatitudeUrl extends GoogleUrl {

  @Key
  public String granularity;

  @Key("min-time")
  public String minTime;

  @Key("max-time")
  public String maxTime;

  @Key("max-results")
  public String maxResults;

  /** Constructs a new Latitude URL from the given encoded URI. */
  public LatitudeUrl(String encodedUrl) {
    super(encodedUrl);
  }

  private static LatitudeUrl root() {
    return new LatitudeUrl("https://www.googleapis.com/latitude/v1");
  }

  public static LatitudeUrl forCurrentLocation() {
    LatitudeUrl result = root();
    result.pathParts.add("currentLocation");
    return result;
  }

  public static LatitudeUrl forLocation() {
    LatitudeUrl result = root();
    result.pathParts.add("location");
    return result;
  }

  public static LatitudeUrl forLocation(Long timestampMs) {
    LatitudeUrl result = forLocation();
    result.pathParts.add(timestampMs.toString());
    return result;
  }
}