public class B extends A {

    private int i;

    public B () {
        super();
        i = 0;
        System.out.println(i);
    }

    public void init () {
        i = 1;
    }
}