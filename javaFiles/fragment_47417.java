public class GSONReading {
    public static void main(String[] a) throws IOException {
        FileReader jsonReader = new FileReader(new File("json.json"));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonReader, JsonObject.class);
        JsonArray fdnJsonArray = (JsonArray) jsonObject.get("FDN");
        fdnJsonArray.forEach(jsonElement -> {
            JsonArray clJsonArray = jsonElement.getAsJsonObject().get("CL").getAsJsonArray();
            clJsonArray.forEach(clJsonItem -> {
                JsonArray kJsonArray = clJsonItem.getAsJsonObject().get("K").getAsJsonArray();
                kJsonArray.forEach(kArrayElement -> {
                    String fid = kArrayElement.getAsJsonObject().get("FID").getAsString();
                    if(fid != null && !fid.isEmpty() && fid.equalsIgnoreCase("LANGUAGE_ID")) {
                        String val = kArrayElement.getAsJsonObject().get("VAL").getAsString();
                        System.out.println(fid + ":"+ val);
                    }
                });
            });
        });
    }
}