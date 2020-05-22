public interface IPrinter {
    void print();
}

public class RealPrinter implements IPrinter {

    @Override
    public void print() {
        System.out.println("This is RealPrinter");
    }
}

public class RealPrinter2 implements IPrinter {

    @Override
    public void print() {
        System.out.println("This is RealPrinter2");
    }
}

public class Main {

    public static void main(String...arg){
        IPrinter printer  = new RealPrinter();
        printer.print();

        printer = new RealPrinter2();
        printer.print();
    }
}