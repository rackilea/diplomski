public class B {

    private final A creator; 

    public B(A creator) {
        // you might want to check for non null A
        this.creator = creator;
    }

    public void foo(String value) {
        creator.setText(value);
    }
}