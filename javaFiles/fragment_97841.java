String songName = finalObject.getJSONObject("track").getString("artist");

{
    "type":"result",
    "data":[                            // fetch JSONArray
        {                               // fetch first JSONObject
             "title":"My Stream ","song":"Unknown - The Authorised One",
             "track":{                  // fetch track JSONObject
                  "artist":"Unknown .." // fetch string