public abstract class AbstractResource extends CoapResource {

    private LinkedList<String> wildcards;

    protected AbstractResource (String name) {
        super (name);
    }

    protected AbstractResource (String name, boolean visible) {
        super (name, visible);
    }

    public LinkedList<String> getWildcards () {
        return wildcards;
    }

    public void setWildcards (LinkedList<String> wildcards) {
        this.wildcards = wildcards;
    }
}