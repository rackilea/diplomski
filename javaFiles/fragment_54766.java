public class Wrapper {
    private WrappedClass w;

    public Wrapper(WrappedClass w) {
       this.w = w;  
    }

    // Forward calls to WrappedClass methods to the private instance.
    public ReturnType example(Argument a) { return w.example(a); }

    // Add your methods here:
}