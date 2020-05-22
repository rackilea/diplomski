import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sizeof {

    public static class Person implements Serializable {
        private String name;
        private String age;

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alby", "20");
        Person p2 = new Person("VeryLongName", "100");
        String s1 = "This is it";
        String s2 = "This";

        try {
            System.out.println("p1 " + sizeof(p1));
            System.out.println("p2 " + sizeof(p2));
            System.out.println("s1 " + sizeof(s1));
            System.out.println("s2 " + sizeof(s2));                                 
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static int sizeof(Object obj) throws IOException {

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);

        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();

        return byteOutputStream.toByteArray().length;
    }
}