public class ViewState {

    private final BooleanProperty atShowing = new SimpleBooleanProperty();

    public BooleanProperty atShowingProperty() {
        return atShowing ;
    }

    public final boolean isAtShowing() {
        return atShowingProperty().get();
    }

    public final void setAtShowing(boolean atShowing) {
        atShowingProperty().set(atShowing);
    }
}