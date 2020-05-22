String url = "https://maps.googleapis.com/maps/api/geocode/json";
String address = "Red Light District";
URIBuilder builder = new URIBuilder(url).setParameter("address", address);

Content response = Request.Get(builder.build()).execute().returnContent();

System.out.println(response);