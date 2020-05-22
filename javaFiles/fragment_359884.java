public abstract class StringBinding {

    private boolean valid = false;
    private String value ;

    protected void bind(ObservableStringValue dependency) {
        dependency.addListener(o -> invalidate());
    }

    private void invalidate() {
        valid = false ;
        // notify invalidation listeners...
    }

    public String get() {
        if (!valid) {
            value = computeValue();
            valid = true ;
        }
        return value ;
    }

    public abstract String computeValue();
}