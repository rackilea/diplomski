interface Detectable {}
interface SomeDetectable extends Detectable {}

abstract class Detect<D extends Detectable> {
    private final Class<D> dClass;
    private final Set<D> detect = new LinkedHashSet<>();

    protected Detect(Class<D> dClass) {
        this.dClass = dClass;
    }

    void supplying(Detectable d) {
        if (dClass.isInstance(d)) {
            detect.add(dClass.cast(d));
        }
    }
}

class SomeDetect extends Detect<SomeDetectable> {
    SomeDetect() {
        super(SomeDetectable.class);
    }
}