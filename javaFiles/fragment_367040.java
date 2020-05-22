public class msgbox extends Plugin {
    private static final String SHOW = "show";
    private static final int MSG_INDEX = 0;
    private String msg;
    private final Activity parent;

    // constructor
    public msgbox(Activity parent) {
        this.parent = parent;
    }