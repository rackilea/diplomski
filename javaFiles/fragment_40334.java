public class IconManager {
    private static iconManager _instance;
    private static final long GUID = 0xab4dd61c5d004c18L;
    private static int count = 0;

    // constructor
    IconManager() {
    }

    public static IconManager getInstance() {
        if (_instance == null) {
            _instance = (IconManager) RuntimeStore.getRuntimeStore().get(GUID);
            if (_instance == null) {
                IconManager singleton = new IconManager();

                RuntimeStore.getRuntimeStore().put(GUID, singleton);
                _instance = singleton;
            }
        }
        return _instance;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        this.count = count;
    }