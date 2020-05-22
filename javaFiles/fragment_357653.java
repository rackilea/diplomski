JSONObject json = new JSONObject("{\"key1\": \"val1\",\n" + 
        " \"key2\": {\"level2\": {\"level3\": \"val3\"}}\n" + 
        "}");

JSONObject json1 = new JSONObject("{\"key1\": \"val1\",\n" + 
        " \"key2\": {\"level2\": [{\"level3\": \"val3\"}]}\n" + 
        "}");

if(json.getJSONObject("key2").optJSONObject("level2") != null) {
    System.out.println("json : it is a jsonobject");
}
else if(json.getJSONObject("key2").optJSONArray("level2") != null) {
    System.out.println("json : it is a jsonarray");
}


if(json1.getJSONObject("key2").optJSONObject("level2") != null) {
    System.out.println("json1 : it is a jsonobject");
}
else if(json1.getJSONObject("key2").optJSONArray("level2") != null) {
    System.out.println("json1 : it is a jsonarray");
}