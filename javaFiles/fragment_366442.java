public interface ServerConfiguration {
    String getHeader();
    String getPath();
    ...
}

public enum DefaultServerConfiguration implements ServerConfiguration {
    INSTANCE;
    private static final String API_USER_SESSION_HEADER = "Cookie";
    private static final String API_SAVE_SETTINGS_PATH = "user/{user_id}/update";
    ...

    @Override
    public String getHeader() {
        return API_SAVE_SETTINGS_PATH;
    }

    @Override
    public String getPath() {
        return API_SAVE_SETTINGS_PATH;
    }
    ...
}
public class SaveSettingsOnServerAdapterImpl implements SaveSettingsOnServerAdapter {

    private final ServerConfiguration config;
    public SaveSettingsOnServerAdapterImpl(ServerConfiguration config) {
        this.config = config;
    }

    @Override
    void saveSettings(User user, OnSaveSettingsOnServerListener listener) {
        new Request().withHeader(config.getHeader());
    }

}

public class UserOfAllThis {
    new SaveSettingsOnServerAdapterImpl(DefaultServerConfiguration.INSTANCE);
}