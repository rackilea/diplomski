public static void main(String[] args) throws IOException {
    String json = "{\"username\":\"user1\",\"password\":\"123456\",\"country\":\"US\",\"creditCardNumber\":\"1283-1238-0458-3458\"}";

    Gson gson = new Gson();
    User user = gson.fromJson(json, User.class);

    System.out.println(gson.toJson(user));

    Gson gsonExpose = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    System.out.println(gsonExpose.toJson(user));
}

public class User {
    @Expose
    private String username;
    private String password;
    @Expose
    private String country;
    private String creditCardNumber;
}