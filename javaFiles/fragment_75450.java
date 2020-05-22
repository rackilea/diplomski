Interface:
public interface InterfaceClass {
    void interfaceMethod();
    //no method definition
}


//Abstract Class implementing InterfaceClass
abstract class AbsClass implements InterfaceClass{
    abstract void abstractMethod();
    public void doSomethingCommon() {
        System.out.println("Abstract class may contain method definition");
    }
    //no need to implement methods of InterfaceClass because AbsClass is abstract
}