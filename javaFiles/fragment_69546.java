public JSONObject toJson() {
    JSONObject obj = new JSONObject().put("id", this.id).put("travelerId", this.travelerId).put("status", this.status);

    if (flights != null) {
      JSONArray flightArray = new JSONArray();
      for (int i = 0; i < flights.size(); ++i) {
        flightArray.put(flights.get(i).toJson());
      }
      obj.put("flights", flightArray);
    }

    if (hotels != null) {
      JSONArray hotelArray = new JSONArray();
      for (int i = 0; i < hotels.size(); ++i) {
        hotelArray.put(hotels.get(i).toJson());
      }
      obj.put("hotels", hotelArray);
    }

    if (cars != null) {
      JSONArray carArray = new JSONArray();
      for (int i = 0; i < cars.size(); ++i) {
        carArray.put(cars.get(i).toJson());
      }
      obj.put("cars", carArray);
    }
    return obj;
  }