/*Try using Gson library to prepare Json string from your service, sample code is given below    

JsonObject myObj = new JsonObject(); //Create Json Object

myObj.addProperty("Email", person.getName()); //Add properties to your Json object
myObj.addProperty("pass", person.getCountry());

return new Gson().toJson(myObj); //Convert Json Object to String and return from your service*/


HttpResponse response = httpClient.execute(httpPost);
HttpEntity entity = response.getEntity();
String resp = null;
JsonObject myObj = null;

if (entity != null) {
    resp = EntityUtils.toString(entity);
    Gson gson = new Gson();

    myObj = gson.fromJson(resp, JsonElement.class).getAsJsonObject();
}