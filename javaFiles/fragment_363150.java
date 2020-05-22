package cobainterface;

public class ImplementedClass Implements MyInterface<ClassA> {
    public void myMethodFromClassA(ClassA c) {
        //System.out.println(c.getTwo()); <- wrong when call method c.getTwo()
    }
}