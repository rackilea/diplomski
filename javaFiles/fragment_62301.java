@SuppressWarnings("unchecked")
public <X> void prepareArgsAndDoTheWork() {
    OldWorkUnit w = new OldWorkUnit();
    w.setExtra(new FooWorkUnit());

    Adapter<X> a = (Adapter<X>) ... ; // Obtain the Adapter by reflection etc 
    WorkUnit<X> unit = w.toNewWorkUnit(a);
    a.doWork(unit);
}