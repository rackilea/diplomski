public class ViewDiagramPresenter extends
        PresenterWidget<ViewDiagramPresenter.MyView> {

    protected final PlaceManager placeManager;

    @Inject
    public ViewDiagramPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy, final PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
    }

    @Override
    public void onReset() {
        super.onReset();
        PlaceRequest placeRequest = placeManager.getCurrentPlaceRequest();
        String actionString = placeRequest.getParameter("action", "view");
    }
}