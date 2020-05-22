MuleClient client = new MuleClient(muleContext);
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("Content-type", "text/plain");
    properties.put("Accept", "text/plain");
    properties.put("http.method", "GET");

    MuleMessage result = client.send("http://localhost:5000/rest/resource?param1=268", null, properties);