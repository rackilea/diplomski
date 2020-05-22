LatitudeUrl latitudeUrl = LatitudeUrl.forLocation();
    latitudeUrl.maxResults="20";
    latitudeUrl.minTime="123";
    latitudeUrl.minTime="456";

    System.out.println(latitudeUrl.build());