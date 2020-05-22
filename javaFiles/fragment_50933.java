public class Customer {
    private final PropertyChangeSupport support = new PropertyChangeSupport();

    public final Property<String> name = Property.newInstance("name", "", support);
    public final Property<Integer> age = Property.newInstance("age", 0, support);

    ... declare add/remove listenener ...
}


Customer c = new Customer();
c.name.setValue("Hyrum");
c.age.setValue(49);
System.out.println("%s : %s", c.name, c.age);