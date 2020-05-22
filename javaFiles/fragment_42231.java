public interface WithMethod {
    // other methods
    void method();
}

public interface WithoutMethod {
    // other methods
    // no 'method()'
}

public abstract class A {
    protected void method();
}

public class B extends A implements WithMethod {
    @Override
    public void method(){
      //TODO
    }
}

public class C extends B implements WithoutMethod {
    // no 'method()'
}