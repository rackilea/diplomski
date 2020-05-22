abstract class Foo{
    public void wobble() {
        //code A
    }
}

class Bar extends Foo{
    //overridden
    public void wobble() {
        //code B
    }

    public void wibble() {
        //some other code C
    }
}

public class Test {
    public static void main(String[] args) {
        Bar b = new Bar();
        b.wobble(); //runs code B
        b.wibble(); //runs code C

        Foo f = (Foo)b;
        f.wobble(); //runs code B
        f.wibble(); //doesn't compile

        Foo foo2 = new Foo(); //trick cannot instantiate abstract class
        foo2.wobble(); //runs code A (if instantiated which it cant be)
        foo2.wibble(); //will not compile because Foo does not have the wibble method
    }

}