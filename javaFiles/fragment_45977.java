@DefaultGatekeeper
public class LoggedInGatekeeper implements Gatekeeper {
    private CurrentUser currentUser;
    private PlaceManager placeManager;

    @Inject
    public LoggedInGatekeeper(CurrentUser currentUser, PlaceManager placeManager) {
        this.currentUser = currentUser;
        this.placeManager = placeManager;
    }

    @Override
    public boolean canReveal() {
        PlaceRequest request = placeManager.getCurrentPlaceRequest();
        if (request.hasSameNameToken('someNameToken') {

           return currentUser.isLoggedIn();
        }
        return true;
    }
}