import com.google.gson.Gson;

public class JsonToJavaObjMapper {

    public static void main(String[] args) {
        String jsonString = "{\"user_name\":\"Azim\",\"zip_code\":null}";
        Gson gson = new Gson();
        User fromJson = gson.fromJson(jsonString, User.class);
        System.out.println(fromJson.getUser_name() + " " + fromJson.getZip_code());
    }
}