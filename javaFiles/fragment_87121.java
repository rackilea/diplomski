import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Person> persons = new ArrayList<>();
        persons.add( new Person("John", "Canada") );
        persons.add( new Person("John", "USA") );
        persons.add( new Person("John", "Mexico") );

        //java 8
        persons.stream().forEach((p) -> {
            System.out.println("Name: " + p.getName() +", Address: "+ p.getAddress());
        });

        //java 7
        for(Person p : persons){
            System.out.println("Name: " + p.getName() +", Address: "+ p.getAddress());
        }

    }

}

class Person {

    private final String name;
    private final String address;

    public Person(String name, String address){
        this.name = name; 
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}