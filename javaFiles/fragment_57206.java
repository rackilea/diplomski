public class B extends SomeAbstract {

    public B(A a) {
        super(a);
        this.specificAttribute = a.somethingElse;
    }

}