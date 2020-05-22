private void modJO(JSONObject job){
    Iterator keys = job.keys();
    while(keys.hasNext()) {
        String currentKey = (String)keys.next();
        JSONObject job2 = job.optJSONObject(currentKey);
        JSONArray jar = job.optJSONArray(currentKey);
        // If JSON Object
        if(job2 != null){
            modJO(job2);
        }
        // If JSON Array
        else if(jar != null){
            modJA(jar);
        }
        // If JSON Property
        else {
            if(currentKey.equals("cid")){
                try{
                    job.put(currentKey,"redacted");
                }
                catch(Exception ex){}
            }
        }
    }
}

private void modJA(JSONArray jar){
    for(int i = 0; i < jar.length(); i++){
        JSONObject job = jar.optJSONObject(i);
        JSONArray jar2 = jar.optJSONArray(i);

        if (job != null){
            modJO(job);
        }
        else if (jar2 != null){
            modJA(jar2);
        }
    }
}