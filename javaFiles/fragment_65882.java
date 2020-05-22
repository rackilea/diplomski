JsonObject file = new Gson().fromJson(repCode.get("file").toString(),JsonObject.class);

if(file.has("references") &&  file.get("references").isJsonArray()){
    JsonArray referencesList = file.get("references").getAsJsonArray();

    if(referencesList.size() != 0){
        references = new String[referencesList.size()];
        for(int i = 0 ; i < references.length ; i++){
             references[i] = referencesList.get(i).getAsString();
        }
    }else references = new String[]{"No previous references found"};
}