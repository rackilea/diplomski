public class ForbiddenDispatcherCallback implements RequestCallback {
    protected RequestCallback requestCallback;
    protected PlaceManager placeManager;

    @Inject
    public ForbiddenDispatcherCallback(PlaceManager placeManager, @Assisted Method method) {
        this.placeManager = placeManager;
        this.requestCallback = method.builder.getCallback();
    }
}