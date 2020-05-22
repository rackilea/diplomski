public abstract class AbstractOne {

    // Obligated to implement in all derived concrete classes
    public abstract void pay();

    // Can be used as is or could be overrided
    public void getTax() {
        System.out.println("Getting general tax");
    }
}

public class Derived1 extends AbstractOne {

    // Obligated to override
    @Override
    public void pay() {
        System.out.println("Pay by cash");
    }
}

public class Derived2 extends AbstractOne {

    // Obligated to override
    @Override
    public void pay() {
        System.out.println("Pay by card");
    }

    // Optional override
    @Override
    public void getTax() {
        System.out.println("Some new tax");
    }
}