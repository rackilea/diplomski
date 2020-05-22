try
{
    // create a Restlet client
    ClientResource cr = new ClienResource("http://api.example.com/login-ajax");
    // create the JSON message
    JSONObject message = new JSONObject();
    message.put("email", "mail@gmail.com");
    message.put("password", "pass");
    // use HTTP POST method to send the JSON message
    cr.post(message, MediaType.APPLICATION_JSON);

    // receive the answer - error checks omitted!
    Response response = cr.getResponse();
    JsonRepresentation jsonRep = new JsonRepresentation(response.getEntity());

    // process the JSON response
    JSONObject json = jsonRep.getJsonObject();
    System.out.println("success: "+json.get("success"));
    System.out.println("current user: "+json.get("currentUser"));

    // extract the user data
    JSONObject userData = (JSONObject)json.get("userData");
    System.out.println("display name: "+userData.get("displayName"));
    System.out.println("display avatar Id: "+userData.get("displayAvatarId"));
    System.out.println("email: "+userData.get("email"));
    System.out.println("is email confirmed: "+userData.get("isEmailConfirmed"));
    System.out.println("sex: "+userData.get("sex"));
}
catch (ResourceException | JSONException ex)
{
    ex.printStackTrace();
}