for(int i=0;i<2;i++)
{
    JsonArray jsonarray = new JsonArray();
    JsonObject pacs_obj = new JsonObject();
    pacs_obj.addProperty("pac_id", "1235");
    jsonarray.add(pacs_obj);
    String new_catid = "1";

    if (datafromdb.containsKey(new_catid)) {
        datafromdb.get(new_catid).add(jsonarray);
    }
    else{
        datafromdb.put(new_catid, jsonarray);
    }
}