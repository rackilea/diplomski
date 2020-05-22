public final class ActionFirstImplAdapter implements Action {
    private final ActionFirstImpl delegate;

    public ActionFirstImplAdapter(ActionFirstImpl delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doAction() {
        delegate.doAction();
    }
}