public interface Attribs {
    String getAttrib1();
    int getAttrib2();
}

public class CusClass1 implements Attribs {
    // ...
}

public class CusClass2 implements Attribs {
    // ...
}

public class MyClass {
    // You can now pass anything that implements interface Attribs
    public MyClass(Attribs myObject) {
        globalVar1 = myObject.getAttrib1();
        globalVar2 = myObject.getAttrib2();
    }
}