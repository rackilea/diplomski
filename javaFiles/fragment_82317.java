DaClass daClass = new Gson().fromJson(jsonString.toString(), DaClass.class);

    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    Map<String, Object> mapOfUndefined = new Gson().fromJson(jsonString.toString(), type);

    mapOfUndefined.remove("first");
    mapOfUndefined.remove("second");

    daClass.mUndefined = mapOfUndefined;