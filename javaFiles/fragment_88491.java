public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T>T toObject(String json, TypeReference<T> typeRef){
        T t = null;
        try {
            t = mapper.readValue(json, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
}