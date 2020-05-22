public interface Printable{
    String print();
}

public interface Showable{
    void print();
}

public class Impl implements Printable,Showable{
    /*impossible to implement because you cannot have the same method signature with two different return types*/
}