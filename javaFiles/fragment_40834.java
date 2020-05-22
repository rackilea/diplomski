JSONObject request = new JSONObject();
JSONObject params =  new JSONObject();

String query =  "MATCH (P:Person { name:{personName} }) \n";
query = query + "MATCH (A:activity { name:{activityName} }) \n";
query = query + "CREATE (P)-[rel:doing { timestamp:{activityTimestamp} }]->(A) \n";
query = query + "RETURN P, A, rel";

request.put("query", query);

params.put("personName", "Piyumi");
params.put("activityName", "walking");
params.put("activityTimestamp", 4789);

request.put("params", params);

ClientResponse cypherResponse = cypherResource.accept(MediaType.APPLICATION_JSON)
            .type(MediaType.APPLICATION_JSON_TYPE)
            .entity(request.toString())
            .post(ClientResponse.class);

System.out.println("Response: " + cypherResponse.getEntity(String.class));