public class Member {
    private final BooleanProperty collected = new SimpleBooleanProperty(true);

    public void setCollected(boolean value) {
        collected.set(value);
    }

    public boolean isCollected() {
        return collected.get();
    }

    public BooleanProperty collectedProperty() {
        return collected;
    }

    ...
}