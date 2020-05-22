public class Application {
public static void main(String[] args) throws Exception{
    User user = new User();
    user.setName("nitin");
    String n = "1111";  //this value comes from API
    SimpleModule module = new SimpleModule();
    module.addSerializer(User.class, new UserSerializer(n));

    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.registerModule(module);

    String xml = xmlMapper.writeValueAsString(user);
    System.out.println(xml);
}