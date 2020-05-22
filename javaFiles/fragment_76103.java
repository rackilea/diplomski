public abstract class AbstractClass {

    public abstract void abstractMethod();
    public  void concreteMethod(){
        System.out.println("am in concreteMethod");
    }

}

public class ExtndClass extends AbstractClass{

    @Override
    public void abstractMethod() {
        // TODO Auto-generated method stub
        System.out.println(" am in extended class");
    }
    public static void main(String...arg){
        AbstractClass abs = new ExtndClass();
        abs.abstractMethod();
        abs.concreteMethod();

    }

}