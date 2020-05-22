class AssistResponse {

    @SerializedName("DateSent")
    private Date dateSent;
    @SerializedName("UserName")
    public String userName;
    // getter & setter
}


class AssistResponseDeserializer implements JsonDeserializer<AssistResponse> {

    @Override
    public AssistResponse deserialize(final JsonElement json, final Type typeOfT,
            final JsonDeserializationContext context) throws JsonParseException {

        JsonArray jsonArray = json.getAsJsonArray();
        JsonElement jsonElement = jsonArray.get(0);
        JsonObject jsonObject = (JsonObject) jsonElement;

        AssistResponse assistResponse = new AssistResponse();
        assistResponse.setUserName(jsonObject.get("UserName").getAsString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = jsonObject.get("DateSent").getAsString();
        try {
            Date date = dateFormat.parse(dateString);
            Date localDate=...              // <== here change it to local date
            assistResponse.setDateSent(localDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return assistResponse;
    }
}
AssistResponse data = new GsonBuilder()
        .registerTypeAdapter(AssistResponse.class, new AssistResponseDeserializer())
        .create().fromJson(jsonString, AssistResponse.class);

System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(data));