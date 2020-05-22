e.g getString -> for getting String, 
    getInt->for getting Integer, 
    JSONObject-> for getting an JSONObject 
    getJSONArray-> for getting a JSONArray


JSONObject jsonObj=new JSONObject(pass your String) //This converts in to JSON Object
jsonObj.getJSONOObject("Results").getString("Message"); //As result internally itself is a JSON Object