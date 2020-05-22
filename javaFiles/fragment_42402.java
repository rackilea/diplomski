public static Targeting targetCustomAudience(List<String> countrylist, String customAudienceID) {

        TargetingGeoLocation geoLocation = new TargetingGeoLocation()
                .setFieldCountries(countrylist);
        /**
         * add geo-location to targeting
         * add custom audienceId to targeting
         */
        Targeting targeting = new Targeting()
                .setFieldGeoLocations(geoLocation)
                .setFieldCustomAudiences("[{id:" + customAudienceID + "}]");
        return targeting;
    }