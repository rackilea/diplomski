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

    public boolean equals(Object o){
        if(! (o instanceof Person)) return false; //a Person can't be equal to a non-person

        Person p = (Person) o;
        return personName == null && p.personName == null || personName.equals(p.personName);
    }

    public int hashCode(){
        return personName == null ? 0 : personName.hashCode();
    }
}