for (int i=0; i < array.length(); i++){
    JSONObject itemArr = (JSONObject)arr.get(i);
    if(itemArr.get("IDSERV").getAsString().equals("2")){
        itemArr.put("STATUSUPDATE", 1);
    }else if(itemArr.get("IDSERV").getAsString().equals("3")){
        itemArr.put("STATUSUPDATE", 2);
    }
}