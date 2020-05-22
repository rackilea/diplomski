String jsonstring="{
    "XXXX": {
        "type": "RSS",
        "value": ""
    },
    "YYYY": {
        "type": "String",
        "value": ""
    },
    "ZZZZ": {
        "type": "String",
        "value": ""
    }
}";

JSONObject object=new JSONObject(jsonstring);
JSONObject childobject=object.getJSONObject("XXXX");

JSONObject modifiedjson=new JSONObject();
modifiedjson.put("type",childobject.get("type"));
modifiedjson.put("value","newvalue");  // Add new value of XXXX here

//

JSONObject mmjson=new JSONObject();
mmjson.put("type","image");
mmjson.put("value","a7e8bec0-87ed-11e2-aa2e-52540025ab96_2_1362746556");  // Add new value of MMM here

JSONObject newjson=new JSONObject();
newjson.put("MMMM",mmjson.toString());
newjson.put("XXXX",modifiedjson.toString());
newjson.put("YYYY",object.get("YYYY"));
newjson.put("ZZZZ",object.get("ZZZZ"));