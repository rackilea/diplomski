if(data!= null){ // add this if condition too.

JSONObject jsonObj = new JSONObject(data);
JSONArray myJsonArray = jsonObj.getJSONArray("result"); ;  //store json in a json array
             for (int i = 0; i < myJsonArray.length(); i++) {
                    //Itterate through the array and get each object i.e btc,ltc
                     JSONObject myJsonObject = (JSONObject) myJsonArray.get(i);