import com.apple.eawt.*;
Application.getApplication().setQuitHandler(new QuitHandler() {
    @Override
    public void handleQuitRequestWith(AppEvent.QuitEvent quitEvent, QuitResponse quitResponse) {
        System.exit(0);
    }
});