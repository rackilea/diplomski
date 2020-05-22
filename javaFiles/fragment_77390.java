LocationRequest request = 
        LocationRequest
            .create()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(100);

source.flatMap(item ->
        locationProvider
                .getUpdatedLocation(request)
                .first(location -> location.getAccuracy() < 5.0f)
                .map(location -> new ItemWithLocation<>(item, location))
);