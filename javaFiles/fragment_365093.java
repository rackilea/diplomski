Gson gson = new GsonBuilder().create();
ResultJson result = gson.fromJson(jsonStringAsShownAbove, ResultJson.class); 

class ResultJson {
    private String email;
    private List<TimeAndLocation> items = new ArrayList<TimeAndLocation>();
}

class TimeAndLocation {
    private double lat;
    private double lon;
    private String tim;
}