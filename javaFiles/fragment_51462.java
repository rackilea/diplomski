public class GeoWebChromeClient extends WebChromeClient {
    @Override
    public void onGeolocationPermissionsShowPrompt(String origin,GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);
    }
}