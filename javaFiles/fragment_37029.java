import java.util.ArrayList;
import java.util.List;


public class FamilyTree {
    List<Person> personList;
    public FamilyTree(){
        personList = new ArrayList();
    }

    public void addPerson(Person person){
        personList.add(person);
    }


    public static void main(String[] args){
        FamilyTree famtree = new FamilyTree();
        Person person = new Person("Emre");
        famtree.addPerson(person);
    }
}

class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }
}