public abstract class Bolt<S extends BoltSpec> {

    private S spec;

    public S getSpec() {
        return spec;
    }

    public void setSpec(S spec) {
        this.spec = spec;
    }

}