JsonObj jsonObj = mapper.readValue(json, JsonObj.class);
System.out.println(jsonObj.getResponseCode());

ResponseObj response = jsonObj.getResponse();
ResultObj firstResult = response.getResult().get(0);
System.out.println(firstResult.getDisplayName());
System.out.println(firstResult.getAvailabilitySeverity());
System.out.println(firstResult.getResourceId());
System.out.println(firstResult.getType());
System.out.println(firstResult.getShortMessage());
System.out.println(response.getUri());