public static void main(String[] args) throws IOException {
    String json = "{\"username\":\"user1\",\"password\":\"123456\",\"country\":\"US\",\"creditCardNumber\":\"1283-1238-0458-3458\"}";

    Gson gson = new Gson();
    User user = gson.fromJson(json, User.class);

    List<String> fieldNames = Arrays.asList("password", "creditCardNumber");
    System.out.println(mask(user, fieldNames, "XXXXXXX"));
}

public static String mask(Object object, List<String> fieldNames, String mask) {
    Field[] fields = object.getClass().getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
        if (fieldNames.contains(fields[i].getName())) {
            try {
                fields[i].setAccessible(true);
                if (fields[i].get(object) != null) {
                    fields[i].set(object, mask);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    Gson gson = new Gson();

    return gson.toJson(object);
}