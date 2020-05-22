private City findNearest(float lat, float lng) {
       float minDist = Float.MAX_VALUE;
       City resCity = null;
       for (City c: cities) {
          float dist = Math.pow(c.getLat() - lat, 2) + Math.pow(c.getLng() - lng, 2);
          if (dist < minDist){
            minDist = dist;
            resCity = c;
          }
       }
     return resCity;
   }