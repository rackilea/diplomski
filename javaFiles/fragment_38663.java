Gson gson = new Gson();

    Map<String, Object> finalObject= new HashMap<>();
    Map<String, Object> sleep= new HashMap<>();
    Map<String, Object> program= new HashMap<>();
    Map<String, String> userInfo= new HashMap<>();
    Map<String, Object> settings= new HashMap<>();

    program.put("appName", "name");
    program.put("appVersion", "1.7");
    program.put("serverVersion", 19);

    userInfo.put("firstName", "Hans");
    userInfo.put("lastName", "Schmidt");
    userInfo.put("city", "Berlin");
    userInfo.put("country", "Germany");


    settings.put("setting1", "y");
    settings.put("setting2", "none");

    sleep.put("program", program);
    sleep.put("userType", "new");
    sleep.put("userInfo", userInfo);
    sleep.put("settings", settings);

    finalObject.put("sleep", sleep);

    System.out.println(gson.toJson(finalObject));