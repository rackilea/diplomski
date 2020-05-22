public class Main {
    public static void main(String[] args) throws IOException {
    GsonBuilder builder = new GsonBuilder();
    builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    Gson gson = builder.create();
    FileInputStream inputStream = new FileInputStream(new File("bobi.json"));
    InputStreamReader reader = new InputStreamReader(inputStream);
    User user = gson.fromJson(reader, User.class);
    System.out.println(user.getName());
    System.out.println(user.getId());
    for (String property : user.getProperties().keySet()) {
        System.out.println("Key: " + property + " value: " + user.getProperties().get(property));
    }
    reader.close();
}