public class Person {

    private String personName;

    public String toString(){
        return personName;
    }

    public Person(String personName){
        this.personName = personName;
    }

    public Person(Person personToCopy){
        this.personName = personToCopy.personName;
    }

}