import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Allows name or age to be null or empty, which I like to do to make things easier on the JavaScript side
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}