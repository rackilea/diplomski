public enum MyClassRegistry
{
    MyClass(1,com.example.MyClass);

    private int typeId;
    private Class<? extends SomeInterface> theClass;

    MyClassRegistry(int typeId, Class<? extends SomeInterface> theClass) {
        this.typeId = typeId;
        this.theClass = theClass;
    }
}