WebClient.create("http://mywebservice.com/search.xml")
    .query("lat", 50.5)
    .query("lng", 30.33)
    .query("fuels", "Diesel")
    .query("radius", 2)
    .get(Search.class);