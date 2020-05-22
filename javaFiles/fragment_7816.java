GsonBuilder gsonBuilder = new GsonBuilder();

gsonBuilder.registerTypeAdapter(ErrorLog.class, new JsonDeserializer<ErrorLog>() {
  @Override
  public ErrorLog deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    ErrorLog errorLog = new ErrorLog();
    List<String> errorLogList = new ArrayList<>();

    JsonElement errorLogJson = json.getAsJsonObject().get("errorLogList");

    if (errorLogJson.isJsonArray()) {
      JsonArray jsonArray = errorLogJson.getAsJsonArray();
      for (int i = 0; i < jsonArray.size(); i++) {
        errorLogList.add(jsonArray.get(i).getAsString());
      }
    } else{
      errorLogList.add(errorLogJson.getAsString());
    }

    errorLog.setErrorLogList(errorLogList);

    return errorLog;
  }
});

LogData logData = gsonBuilder.create().fromJson(jsonData, LogData.class);