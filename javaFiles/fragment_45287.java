public class B {

    private boolean started;

    private AtomicReference<A> a = new AtomicReference<A>();

    @Reference(name = "a", 
        service = A.class,  
        optional = false,
        multiple = false,
        dynamic = true,
        unbind = "unsetA")
    public void setA(A a) {
        this.a.set(a) = a;
    }

    public void unsetA(A a) {
        this.a.set(null);
        if (!started) {
            componentIsStoppedAndReferencesAreUnset();
        }
    }

    @Activate
    public void activate() {
        started = true;
    }

    @Deactivate
    public void deactivate() {
        started = false;
        if (this.a.get() == null) {
            componentIsStoppedAndReferencesAreUnset();
        }
    }

    public void componentIsStoppedAndReferencesAreUnset() {
        // Implement your logic here
    }
}