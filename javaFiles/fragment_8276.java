public class MirrorDocument extends PlainDocument {

    private boolean ignoreUpdates;

    public void setIgnoreUpdates(boolean ignoreUpdates) {
        this.ignoreUpdates = ignoreUpdates;
    }

    public boolean isIgnoreUpdates() {
        return ignoreUpdates;
    }

}