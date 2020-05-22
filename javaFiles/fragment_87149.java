MuleClient client = new MuleClient(muleContext);
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("Content-Type", "application/json");
    properties.put("http.method", "POST");

    String payload = "{...json here...}";

    MuleMessage result = client.send("http://localhost:5000/rest/resource", payload, properties);