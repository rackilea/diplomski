import com.apple.eawt.*;
...
Application.getApplication().setOpenURIHandler(new OpenURIHandler() {
    @Override
    public void openURI(AppEvent.OpenURIEvent openURIEvent) {
        URI uri = openURIEvent.getURI();
        //TODO handle uri
    }
});