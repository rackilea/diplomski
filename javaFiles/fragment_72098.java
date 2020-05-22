public abstract class ToBeOverriden<E,V> {
    public E method (V parameter);
}

public class Implementation extends ToBeOverriden<DateTime,Person> {
    @Override
    public DateTime method (Person parameter){
        return new DateTime();
    }
}