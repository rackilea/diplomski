public abstract class ABCModel<T> {
    private T baz;

    public T getBaz() { return baz; }

    public void setBaz(T baz) { this.baz = baz; }
}

public class IntModel extends ABCModel<Integer> { // baz is of type Integer   
}

public class FloatModel extends ABCModel<Float> { // baz is of type Float   
}

IntModel m1 = new IntModel();
Integer i = m1.getBaz();

FloatModel m2 = new FloatModel();
Float f = m2.getBaz();