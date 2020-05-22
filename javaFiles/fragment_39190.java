public class Person 
{
    private Name name;
    private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty lastName = new SimpleStringProperty("");
    private IntegerProperty age;

    public Person(Name name) 
    {
        this.firstName.set(name.getFirstName());
        this.lastName.set(name.getLastName());
    }

    public setName(Name name) 
    {
        this.name = name;
        this.firstName.set(name.getFirstName());
        this.lastName.set(name.getLastName());
    }
}