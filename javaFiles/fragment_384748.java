{                              // <-- this is your main object (AKA JSONObject json = new JSONObject(response2))
    "id": 1,                   // to pull this id use json.getInt("id");
    "title": "some text here",  // to pull this title use json.getString("title");
    ...
    "owner": {                 // Here's the logic part, owner is itself, a JSON object. so now you must extract it and parse through it.
                               // to pull the "owner" JSON object, use JSONObject ownerObject = json.getJSONObject("owner");
        "userId": 1,           // Now use the ownerObject to pull it's values. ownerObject.getInt("userId");
        "userName": "TestingUser",  // to pull this userName use ownerObject.getString("userName");
        ...
    }
...
}