public abstract class Superclass {}
public class SubclassA extends Superclass {}
public class SubclassB extends Superclass {}

public abstract class AbstractFactory {
    public abstract Superclass Create();
}

public class FactoryA extends AbstractFactory {
    public Superclass Create() {
        return new SubclassA();
    }
}

public class FactoryB extends AbstractFactory {
    public Superclass Create() {
        return new SubclassB();
    }
}