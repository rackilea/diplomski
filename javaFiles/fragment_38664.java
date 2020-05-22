JsonObject finalJsonObject= new JsonObject();
    JsonObject jsonSleep= new JsonObject();
    JsonObject jsonProgram= new JsonObject();
    JsonObject jsonUserInfo= new JsonObject();
    JsonObject jsonSettings= new JsonObject();

    jsonUserInfo.addProperty("firstName", "Hans");
    jsonUserInfo.addProperty("lastName", "Schmidt");
    jsonUserInfo.addProperty("country", "Germany");
    jsonUserInfo.addProperty("city", "Berlin");


    jsonSettings.addProperty("setting2", "none");
    jsonSettings.addProperty("setting1", "y");

    jsonProgram.addProperty("appVersion", "1.7");
    jsonProgram.addProperty("serverVersion", 19);
    jsonProgram.addProperty("appName", "name");


    jsonSleep.add("userInfo", jsonUserInfo);
    jsonSleep.add("settings", jsonSettings);
    jsonSleep.add("program", jsonProgram);
    jsonSleep.addProperty("userType", "new");

    finalJsonObject.add("sleep", jsonSleep);

    System.out.println(String.valueOf(finalJsonObject));