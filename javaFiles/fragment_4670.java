WSRequest request = new WSRequest("<Method>"); //Method can be GET, POST etc
request.setUrl("<service-url>");
request.setHeader("Content-Type", "application/x-www-form-urlencoded");

com.ning.http.client.FluentStringsMap map = new com.ning.http.client.FluentStringsMap();

map.add("name", "aniket");

Set<String> values= new HashSet<String>();
values.add("1");
values.add("2");
values.add("3");
values.add("4");

map.add("values", values);

request.setQueryParameters(map);

Promise<Response> response = request.execute();