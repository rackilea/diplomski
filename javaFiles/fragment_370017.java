public class Q19657666 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(CRMActivity.class, new CustomDeserializer());

        Gson g = gb.create();

        String json = "{\"__type\": \"CRMService.Activity\","+
        "\"Subject\": \"Call back to understand the problem (sample)\", "+
        "\"Type\": \"Phone Call\", "+
        "\"RegardingObjectType\": \"account\","+
        "\"RegardingObjectId\": \"f3259a52-672f-e311-a7d8-d89d6765b134\","+
        "\"EndTime\": \"/Date(1381226400000)/\","+
        "\"Id\": \"50b79458-672f-e311-a7d8-d89d6765b134\","+
        "\"StartTime\": \"/Date(1381226400000)/\"}";

        CRMActivity crmActivity = g.fromJson(json, CRMActivity.class);

        System.out.println(crmActivity);
    }

}