List<StopItem> distanceHistory = new ArrayList<>();

    while (rsLatLong.next()) {
        double latStop = rsLatLong.getDouble("lat");
        double lonStop = rsLatLong.getDouble("longi");
        double distStop = haversineDistance(latD, longD, latStop, lonStop);
        StopItem newItem = new StopItem( latStop, lonStop, distStop );
        distanceHistory.add(newItem);

    }