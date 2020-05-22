public abstract class A {
    protected void method();
}

public class B extends A {
    @Override
    public void method(){    // OK
    }
}

public class C extends A {
    @Override
    private void method(){    // not allowed
    }
}