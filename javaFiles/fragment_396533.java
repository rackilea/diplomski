public class OtherClass {

    private ISomeInterface obj;

    public OtherClass(ISomeInterface obj) {
        this.obj = obj;
    }

    public int myMethod() {
        //do some stuff
        int result = obj.doSomething();

        //do some other stuff
        return something;
    }
}