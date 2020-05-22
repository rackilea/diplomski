class Main {

    interface CarElement {
       ...
    }

    interface CarElementVisitor {
        ...
    }

    class Car implements CarElement {
        ...
    }

    ...

    class CarElementPrintVisitor implements CarElementVisitor {
        ...
    }

    public class VisitorDemo {
        ...
    }

}