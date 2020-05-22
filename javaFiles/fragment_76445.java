public class MyClass{

    class ArrayDescriptorFactory{
        makeArrayDescriptor(String name, Connection connection){
            return ArrayDescriptor.createDescriptor(name, connection);
        }
    }

    private ArrayDescriptorFactory factory;

    public MyClass(){
        this( new ArrayDescriptorFactory());
    }

    MyClass(ArrayDescriptorFactory factory){
        this.factory = factory;
    }

    public void doSomething(){
        ... do stuff ...
        factory.makeArrayDescriptor( "something", someConnection );
        ... do more stuff ...
    }
}