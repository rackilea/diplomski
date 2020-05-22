@Override
public HistoryRecord deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    JsonObject object = json.getAsJsonObject();
    JsonObject extras = object.get("extraData").getAsJsonObject();

    HistoryRecord hr = object.context.deserialize(object.get("data"), HistoryRecord.class);
    hr.appendExtraData(extras, HistoryRecordExtraData.class);
    ...
    }