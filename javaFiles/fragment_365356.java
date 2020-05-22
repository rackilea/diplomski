public class ClassB extends AbstractClass {

    private final AbstractClass other;

    public ClassB(AbstractClass other) {
        this.other = other;
    }

    public void F() {
         other.F();
    }    
}