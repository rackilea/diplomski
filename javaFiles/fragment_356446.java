public abstract class GsonUtils {
    private static Gson gson = new Gson();

    static {
        // your extra init logic goes here
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }


    public static String toJson(Object object) {
        if (object == null) {
            return "";
        }
        return gson.toJson(object);
    }
}