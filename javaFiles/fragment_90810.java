final JSONObject jsonObject = new JSONObject();
    Map<String, String> map = new HashMap<>();
    map.put("voteBallot", "string");
    map.put("voterEmail", "string");
    try {

        jsonObject.put("name", "new name");
        jsonObject.put("description", "new election");
        jsonObject.put("candidates", new String[] {"new String"});
        jsonObject.put("ballotVisibility", "string");
        jsonObject.put("voterListVisibility", true);
        jsonObject.put("startingDate", LocalDateTime.now().atZone(ZoneOffset.UTC));
        jsonObject.put("ballot", new Map[]{map});
        System.out.println("jsonObject = " + jsonObject);
    } catch (JSONException e) {
        e.printStackTrace();
    }