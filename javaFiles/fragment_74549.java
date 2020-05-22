public abstract class AbsClass<T extends A> {
    protected List<T> list;
}

public class ConClass extends AbsClass<B> {
    list = new ArrayList<B>();
}