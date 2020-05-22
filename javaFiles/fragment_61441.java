// Executing "me" and "me/friends?limit=50" endpoints
BatchRequests<BatchRequest> batch = new BatchRequests<BatchRequest>();
batch.add(new BatchRequest(RequestMethod.GET, "me"));
batch.add(new BatchRequest(RequestMethod.GET, "me/friends?limit=50"));
List<BatchResponse> results = facebook.executeBatch(batch);

BatchResponse result1 = results.get(0);
BatchResponse result2 = results.get(1);

// You can get http status code or headers
int statusCode1 = result1.getStatusCode();
String contentType = result1.getResponseHeader("Content-Type");

// You can get body content via as****() method
String jsonString = result1.asString();
JSONObject jsonObject = result1.asJSONObject();
ResponseList<JSONObject> responseList = result2.asResponseList();

// You can map json to java object using DataObjectFactory#create****()
User user = DataObjectFactory.createUser(jsonString);
Friend friend1 = DataObjectFactory.createFriend(responseList.get(0).toString());
Friend friend2 = DataObjectFactory.createFriend(responseList.get(1).toString());