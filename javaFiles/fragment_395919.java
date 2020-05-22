@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "test")
public class MyProperties {

  private String name;
  private String gender;
  private String age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getInformation(){
    return name + gender + age;
  }

}