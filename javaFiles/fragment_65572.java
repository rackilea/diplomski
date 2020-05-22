public Promise<Response> getDetails(final Place place) {
    Logger.debug(BASE_URL + place.getFqId() + "?client_id=" + KEY + "&client_secret=" + SECRET_KEY + "&v=20140806&m=foursquare");

    Promise<Response> response =
    WS.url(BASE_URL + place.getFqId())
    .setQueryParameter("client_id", KEY)
    .setQueryParameter("client_secret", SECRET_KEY)
    .setQueryParameter("v", "20140806")
    .setQueryParameter("m", "foursquare")
    .setTimeout(TIMEOUT)
    .get().map(
      new Function<WSResponse, Response>() {
        public Response apply(WSResponse response) {
          JsonNode json = response.asJson();
          return new FoursquareResponse(place.getFqId(), json);
        }
      }
    ).recover(new Function<Throwable, Response>() {
      public Response apply(Throwable t) throws Throwable {
        Logger.error("error", t);
        Logger.error(place.getFqId());
        return new FoursquareResponse(place.getFqId(), null);
      }
    });

    return response;
  }