import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Data {
    private static final String SER_FILE = "C:\\view\\data.ser";
    static List<Person> persons = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        Data.savePersons();
        Data.loadPersons();
    }

    public static void savePersons() throws IOException {

        /** Make 5 'Person' object for example */
        for (int i = 0; i < 5; i++) {
            Person personTest = new Person("name" + i, "surname" + i, "email" +i, "1234567890-" +i);
            persons.add(personTest);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SER_FILE, true));) {

            oos.writeObject(persons);
            System.out.println("Saving '" + persons.size() + "' Object to Array");
            System.out.println("persons.size() = " + persons.size());
            System.out.println("savePersons() = OK");

        } catch (Exception ex) {
            System.out.println("Saving ERROR: " + ex.getMessage());
        }
    }

    public static void loadPersons() throws IOException {

        /** Clean 'persons' array for TEST of load data */
        persons.removeAll(persons);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SER_FILE));){

            persons = (List<Person>) ois.readObject(); 
            //persons.add(result);

            System.out.println("-------------------------");
            System.out.println("Loading '" + persons.size() + "' Object from Array");
            System.out.println("persons.size() = " + persons.size());
            System.out.println("loadPersons() = OK");

            persons.stream().forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("-------------------------");
            System.out.println("Loading ERROR: " + e.getMessage());

        }
    }
}

class Person implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String mail;
    private String telephone;

    public Person(String n, String s, String m, String t) {
        name = n;
        surname = s;
        mail = m;
        telephone = t;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", surname=" + surname + ", mail=" + mail + ", telephone=" + telephone + "]";
    }
}