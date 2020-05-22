public class ClassWithFinalInstanceVariable {
    private final int x;
    public ClassWithFinalInstanceVariable() {
       this.x = 100; // We can set it here as it has not yet been set.
    }
    public void doesNotCompileIfUncommented() {
       // this.x = 1;
       // If the line above is uncommented then the application would no longer compile.
    }

    public void hidesXWithLocalX() {
       int x = 1;
       System.out.println(x);
       System.out.println(this.x);     
    }
}