double distance = 0;
 int nearestLocationIndex = 0;
    for(int i = 0; i<locationList.size(); i++) {
        double currentDistance = getDistanceInMeter(locationList.get(i), currentLocation);

        if(i == 0 ) { // Initially we are assuming first position is the nearest
            distance = currentDistance;
            nearestLocationIndex = i;
        } else {
            if(currentDistance < distance) {
                distance = currentDistance;
                nearestLocationIndex = i;
            }
        }

    }