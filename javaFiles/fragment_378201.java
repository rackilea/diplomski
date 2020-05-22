public static List<User> getUsers(String json) {
    final ObjectMapper mapper = new ObjectMapper();

    try {
        final JavaType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
        return mapper.readValue(json, collectionType);
    } catch (IOException e) {
        //You should not hide exceptions. Try to log it at least.
        //But probably application should not start when app configuration is missing or wrong.
        e.printStackTrace();
        return Collections.emptyList();
    }
}