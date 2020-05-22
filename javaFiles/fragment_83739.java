public String createUrlAddress(TypeOfInformation typeOfInformation, String icao) {
    String urlAddress;
    switch (typeOfInformation) {
        case METAR:
            urlAddress = StaticValues.MAIN_URL_ADDRESS_FOR_METAR + icao;
            break;
        case TAF:
            urlAddress = StaticValues.MAIN_URL_ADDRESS_FOR_TAF + icao + StaticValues.TAF_4_HOURS_BEFORE_NOW;
            break;
        case CITY_PAIR_METAR:
            // We delegate the build logic to pc because
            // all the information needed to build the url
            // is in the PageControllerForNearestCity class
            urlAddress = pc.urlAddressForCityPairMetar(); 
            break;
        case CITY_PAIR_TAFS:
            // Same
            urlAddress = pc.urlAddressForCityPairTafs();
            break;
        default:
            System.out.println("Wrong Type of informations");
    }
    return urlAddress;
}

class PageControllerForNearestCity {

    public String urlAddressForCityPairMetar() {
        return urlBasedOn(StaticValues.MAIN_URL_ADDRESS_FOR_CITY_PAIRSS, ",", StaticValues.MOST_RECENT_FOR_TYPED_STATIONS);
    }
    public String urlAddressForCityPairTafs() {
        return urlBasedOn(StaticValues.MAIN_URL_ADDRESS_FOR_CITY_PAIRS_TAFS, ",%20", StaticValues.MOST_RECENT_FOR_TYPED_STATIONS_TAFS);
    }
    // This method removes the duplication that I mentioned before
    private String urlBasedOn(String mainUrl, String separator, String endString) {
        return mainUrl
                + this.getDepartureAndArrivalTime().get("departureTime")
                + StaticValues.END_TIME_STRING
                + this.getDepartureAndArrivalTime().get("arrivalTime")
                + StaticValues.STATION_STRING
                + this.getOriginIcao()
                + separator
                + this.getDestinationIcao()
                + endString;
    }
}