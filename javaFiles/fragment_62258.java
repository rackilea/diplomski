JSONArray arrayHolder = new JSONArray();
if (retStatus.size() > 0) {
    for (int i = 0; i < retStatus.size(); i++) {
        String splited[] = retStatus.get(i).split("\\:");

        JSONObject innerObj = new JSONObject();

        innerObj.put("UniteId:", splited[0]);
        innerObj.put("Message:",splited[1]);
        arrayHolder.put(innerObj);   
    }

    JSONObject finalObject = new JSONObject();
    finalObject.put("uniteids:", arrayHolder);

    System.out.println(finalObject.toString());
}