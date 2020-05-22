public class Person 
{
    private SimpleObjectProperty<Name> name = new SimpleObjectProperty<Name>();
    private IntegerProperty age;

    public Person(Name name) 
    {
        this.name.set(name);
    }
}