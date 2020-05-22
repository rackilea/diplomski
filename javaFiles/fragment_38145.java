List<List<Map<String, String>>> outerList = new ArrayList<>();
    for(ServiceInfo so : serviceInfos){
        List<Map<String, String>> innerList = new ArrayList<>();
        for(JsonObject j : getJsonObjectsForThisServiceInfo(so)){
            Map<String, String> map = new HashMap<>();
            // Fill in the map with what you need
            // ...
            innerList.add(map);
        }
        outerList.add(innerList);

    }
//Use your new list after here for whatever you want :)