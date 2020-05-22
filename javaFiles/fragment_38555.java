public class Wrapper<T>  // Don't use this name either...
{
    private ExtraFields extraFields;
    private T myClass;

    public Wrapper(T myClass) {
        this.myClass = myClass;
        this.extraFields = new ExtraFields();
    }
}