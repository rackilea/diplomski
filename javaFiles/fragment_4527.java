//Character Class
public class Character implements Model {
    public String age;
    }
//Person Class
public class Person implements Model {
    public String name;
}
//Model
public interface Model {
}
//CoreModel
public class CoreModel {

    public static <T extends Model> T getById( int id) throws Exception {
        int idType = id % 10; // the id has to be distinguishable
        // get data from DB
        switch (idType) {
            case 0:

                Person person = new Person();
                person.name = "test";
                return (T) Person.class.cast(person);
            case 1:
                Character character = new Character();
                character.age = "100";
                return (T) Character.class.cast(character);
            default:
                throw new Exception("Type Not Found");
        }
    }
}
//Main Class
public class Main {
    public static void main(String[] args) {

        try {
            Person p = CoreModel.getById(100);
            Character c = CoreModel.getById(101);
            System.out.println(p.name);
            System.out.println(c.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}