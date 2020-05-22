public class User{

  private String username;
  private Integer age;
  private String address;
  private String phone;

  public User addPhoneNumber(String phone){
      this.phone = phone;
      return this;
  }

  public User createInfo(String username, int age, String address){

      this.username =  username;
      this.age = age;
      this.address = address;

      return this;
  }

  public String generateJsonText(){
      JSONObject json = new JSONObject();
      if (username != null) json.put("username", username);
      if (age != null) json.put("age", age);
      if (address != null) json.put("address", address);
      if (phone != null) json.put("phone ", phone );
      return json.toJSONString();
  }

  public static void main(String[] args) {
     User user = new User();
     String json = user.createInfo("xxxx", 11, 112222).addPhoneNumber("1234567").generateJsonText();
  }
}