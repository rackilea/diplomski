public class Subclass1 extends Superclass1
{
    private ExtraFields extraFields;

    public MySubclass()
    {
        super();
        extraFields = new ExtraFields();
    }

    public void doSomethingWithExtraFields()
    {
        extraFields.doSomethingWithExtraFields();
    }
}