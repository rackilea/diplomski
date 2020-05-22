public class Test {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = Test.class.getResourceAsStream("test.json");
        ServiceResponse response = mapper.readValue(is, ServiceResponse.class);
        User user = (User) (mapper.convertValue(response.getData().get(0), User.class));
        System.out.println(user.toString());
        is.close();
    }
}