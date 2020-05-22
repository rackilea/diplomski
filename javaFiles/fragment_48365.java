public class ConfigServiceImpl implements ConfigService {
    private static final ConfigServiceImpl INSTANCE = new ConfigServiceImpl();
    private ConfigServiceImpl() {
        // all the init code here.
        URI resourceDirUri = PROFILE_FIR_URL.toURI();
        File resourceDir = new File(resourceDirUri);
        ...
    }

    // not synchronized because final field
    public static ConfigService getInstance() { return INSTANCE; }
}