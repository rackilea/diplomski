public abstract class AbsClass<T extends A> {
    protected List<T> list = new ArrayList<T>();
}

public class ConClass extends AbsClass<B> {
    //... other stuff ...
}