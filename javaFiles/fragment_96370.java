public class Test {
    @SerializedName("HTML")
    String html;
    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder().create();
        try (Reader reader = new FileReader("test.json")) {
            Test test = gson.fromJson(reader, Test.class);
            System.out.println(test.html);
        }
    }
}