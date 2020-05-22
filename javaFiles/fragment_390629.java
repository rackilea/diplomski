public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Object obj;
        try {
            JsonParser parser = new JsonParser();
            obj = parser.parse(new FileReader("C:\data.json"));
            JsonObject jsonObject = (JsonObject) obj;

            Data data = gson.fromJson(jsonObject, Data.class);
        } catch (JsonIOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}