for (int i = 0; i < theJArray.size(); i++)
{
  JSONObject secondJObj = (JSONObject)theJArray.get(i);
  System.out.println("The secondJobj: " + secondJObj); //one object is one book and its info

  JSONObject volInfo = (JSONObject)secondJObj.get("volumeInfo"); //TODO
    // then get author
   JSONArray specificArr = (JSONArray)volInfo.get("author");
}