RestAPI restAPI = new RestAPIFacade("http://localhost:7474/db/data","","");

...
Map<String, Object> params = new HashMap<String, Object>();
params.put("id",id);
CypherResult theResult = restAPI.query("MATCH (User:User) WHERE User.userid = {id} RETURN User", params);
for (Node user : theResult.to(Node.class)) { 

}