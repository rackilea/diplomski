public class GsonSerialiserTest {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Foobar.class, new TimestampSerializer());
        Gson gson = builder.create();
        Foobar baz = new Foobar("baz", 1, new Timestamp(System.currentTimeMillis()));
        System.out.println(gson.toJson(baz));
    }
}