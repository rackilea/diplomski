Map<String,Object> jsonMap = new HashMap<String,Object>();

    jsonMap.put("name", fullName.toString());
    jsonMap.put("file", file);

    List<Map<String,Object>> listOfObjects = new ArrayList<Map<String,Object>>();
    listOfObjects.add(jsonMap);
    indexService.bulkInsert(listOfObjects);