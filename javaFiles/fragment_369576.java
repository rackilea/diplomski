JSONParser jp=new JSONParser();

JsonObject object=jp.getJSONFromUrl(your url);
JsonObject object2=object.getJsonObject("result");

String Token=object2.getString("token");