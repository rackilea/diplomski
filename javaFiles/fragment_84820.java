String callString = "http://api.pemiluapi.org/calonpresiden/api/caleg/jk?apiKey=56513c05217f73e6be82d5542368ae4f";

Client client = Client.create();
WebResource webResource = client.resource(callString);

ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
if (clientResponse.getStatus() != 200) {
    throw new RuntimeException("Failed"+ clientResponse.toString());
}

JSONObject resObj = (JSONObject)new JSONParser().parse(clientResponse.getEntity(String.class));
JSONObject data_obj = (JSONObject) resObj.get("data");
JSONObject results_obj = (JSONObject) data_obj.get("results");
JSONArray caleg_array = (JSONArray) results_obj.get("caleg");