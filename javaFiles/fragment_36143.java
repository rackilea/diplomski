public interface AsyncResponseWithJSONObject {
    void processFinish(JSONObject output);
}
public interface AsyncResponseWithString {
     void processFinish(String output);
}