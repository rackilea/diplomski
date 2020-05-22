public List<NormalizedSearchResult> getResults()
{
    return searchEjb.findByLocation(getRangeKm(),
                                    getLongitude(),
                                    getLatitude(),
                                    gender,
                                    getSpokenLanguageId(),
                                    getServiceId(),
                                    1,
                                    99,
                                    getStartDate().toDateMidnight().toDate(),
                                    7);
}

public List<NormalizedSearchResult> getResults2()
{
    float lng = longitude;
    float lat = latitude;
    return searchEjb.findByLocation(getRangeKm(),
                                    lng,
                                    lat,
                                    gender,
                                    getSpokenLanguageId(),
                                    getServiceId(),
                                    1,
                                    99,
                                    getStartDate().toDateMidnight().toDate(),
                                    7);
}

public List<NormalizedSearchResult> getResults3()
{
    float lng = getLongitude();
    float lat = getLatitude();
    return searchEjb.findByLocation(getRangeKm(),
                                    lng,
                                    lat,
                                    gender,
                                    getSpokenLanguageId(),
                                    getServiceId(),
                                    1,
                                    99,
                                    getStartDate().toDateMidnight().toDate(),
                                    7);
}

public List<NormalizedSearchResult> getResults4()
{
    float lng = longitude;
    float lat = latitude;
    return searchEjb.findByLocation(getRangeKm(),
                                    138.5999594f,
                                    -34.9286212f,
                                    gender,
                                    getSpokenLanguageId(),
                                    getServiceId(),
                                    1,
                                    99,
                                    getStartDate().toDateMidnight().toDate(),
                                    7);
}

public List<NormalizedSearchResult> getResults5()
{
    float lng = 138.5999594f;
    float lat = -34.9286212f;
    return searchEjb.findByLocation(getRangeKm(),
                                    lng,
                                    lat,
                                    gender,
                                    getSpokenLanguageId(),
                                    getServiceId(),
                                    1,
                                    99,
                                    getStartDate().toDateMidnight().toDate(),
                                    7);
}

public Float getLongitude()
{
    return longitude;
}

public void setLongitude(Float longitude)
{
    this.longitude = longitude;
}

public Float getLatitude()
{
    return latitude;
}

public void setLatitude()
{
    this.latitude = latitude;
}

private Float longitude;
private Float latitude;