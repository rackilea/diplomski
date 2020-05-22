import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

    private static final String UNWRAPPED_JSON = "{\n" +
            "  \"age\" : 13,\n" +
            "  \"first\" : \"Huckleberry\",\n" +
            "  \"last\" : \"Finn\"\n" +
            "}";

    @Test
    public void test() throws IOException {
        System.out.println("### Serialize without unwrapped annotation ###");
        ObjectMapper serializer = new ObjectMapper();
        System.out.println(serializer.writerWithDefaultPrettyPrinter().writeValueAsString(createParent()));

        System.out.println("### Deserialize with unwrapped annotation ###");
        ObjectMapper deserializer = new ObjectMapper();
        deserializer.addMixInAnnotations(Parent.class, ParentMixIn.class);
        System.out.println(deserializer.readValue(UNWRAPPED_JSON, Parent.class));
    }

    private Parent createParent() {
        Name name = new Name();
        name.first = "Tom";
        name.last = "Sawyer";

        Parent parent = new Parent();
        parent.setAge(12);
        parent.setName(name);

        return parent;
    }
}

class Parent {

    private int age;
    private Name name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }
}

interface ParentMixIn {

    @JsonUnwrapped
    Name getName();
}

class Name {

    public String first, last;

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}