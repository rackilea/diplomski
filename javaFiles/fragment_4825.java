public class FooDaoImpl extends AbstractDao<Foo> {
    ...
    public Collection<Foo> getByCriteria(Criteria criteria) {
        ...
    }
}

public class FooBusinessImpl {
    ...
    public void doSomethingWithFoosBetween(Date from, Date to) {
        ...
        Criteria criteria = ...;

        // Build your criteria to get only foos between from and to

        Collection<Foo> foos = fooDaoImpl.getByCriteria(criteria);
        ...
    }

    public void doSomethingWithActiveFoos() {
        ...
        Criteria criteria = ...;

        // Build your criteria to filter out passive foos

        Collection<Foo> foos = fooDaoImpl.getByCriteria(criteria);
        ...
    }
    ...
}