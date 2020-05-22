abstract class Furniture {
    abstract void doSomethingInKitchen();
}

class Table extends Furniture {
    @Override
    void doSomethingInKitchen() {
        // Table-specific logic
    }
}

class Chair extends Furniture {
    @Override
    void doSomethingInKitchen() {
        // Chair-specific logic
    }
}