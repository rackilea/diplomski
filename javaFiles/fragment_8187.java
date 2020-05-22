String result = "";
    for(i = 0; i < geo.getTargets().length ; i++ ){
      if(geo.getTargets(i).getTargetType().equalsIgnoreCase("ProximityTarget")){
        final ProximityTarget prox = (ProximityTarget)geo.getTargets(i);
        float longitude = prox.getGeoPoint().getLatitudeInMicroDegrees()); 
        float lat = prox.getGeoPoint().getLongitudeInMicroDegrees());
        float radius = prox.getRadiusDistanceUnits();

        if (!result.isEmpty()) {
            result += "|";
        }

        result += ("circle:" + longitude + ":" + lat + ":" + radius);
      }
    }

    return result;