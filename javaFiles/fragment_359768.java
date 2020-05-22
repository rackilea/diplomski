public static void main(String[] args) {
    Map<Integer, String> output = new HashMap<Integer, String>();
    Gson gson = new Gson();
    BufferedReader br = null;

    try {
        br = new BufferedReader(new FileReader("stations.json"));
        StationManager sm = gson.fromJson(br, StationManager.class);
        List<JsonObject> listOfObjs = sm.getPseudoStations();
        for(JsonObject obj: listOfObjs){
            output.put(obj.getInt("id"), obj.getString("name"));
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            closeBufferedReader(br);
        }
    }
}