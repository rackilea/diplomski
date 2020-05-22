public class FooDaoImpl {
    ...
    public Collection<Foo> getFoosBetween(Date from ,Date to) {
        // build and execute query according to from and to
    }

    public Collection<Foo> getActiveFoos() {
        // build and execute query to get active foos
    }
}

public class FooBusinessImpl {
    ...
    public void doSomethingWithFoosBetween(Date from, Date to) {
        ...      
        Collection<Foo> foos = fooDaoImpl.getFoosBetween(from, to);
        ...
    }

    public void doSomethingWithActiveFoos() {
        ...
        Collection<Foo> foos = fooDaoImpl.getActiveFoos();
        ...
    }
    ...
}