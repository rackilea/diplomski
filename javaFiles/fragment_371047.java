private static void post(String address) throws Exception {
    StringBuilder http = new StringBuilder();
    http.append("https://maps.googleapis.com/maps/api/geocode/json");
    http.append("?");
    http.append("address=" + address);
    Content resp = Request.Post(http.toString()).execute().returnContent();
    System.out.println(resp);
}