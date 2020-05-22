public interface A { }
public class B implements A {}

public class program {
     B bClass = new B();
     A aObject = (A)bClass;
}