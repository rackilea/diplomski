public class json {

public static void main(String[] args) throws Exception {
    try {
        // This creates a JsonReader object which allows for reading in JSON from a stream
        // You are creating this object with the input of a FileReader, establishing the input stream as that of the file "file"
        JsonReader jsonReader = new JsonReader(new FileReader("file"));

        Gson gson = new Gson();

        // This object stores the JSON result of reading in the input from the file "file" by using the jsonReader object to do so
        // Remember that the jsonReader uses a FileReader under the hood, because that is how you defined it
        JsonElement json = gson.fromJson(jsonReader, JsonElement.class);

        JsonArray array = json.getAsJsonObject().get("rows").getAsJsonArray();
        int length = array.size(); // This returns the number of elements in your JsonArray array and stores it in the length variable
        for (int i = 0; i < length; i++) {
            System.out.println(array.get(i).getAsJsonObject().get("automatic").getAsJsonObject().get("kernel").getAsJsonObject().get("release").getAsString());
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}