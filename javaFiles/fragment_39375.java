// History.class
public class History {

    private static HistoryImpl impl;

    static {
      impl = GWT.create(HistoryImpl.class);
      if (!impl.init()) {
        // Set impl to null as a flag to no-op future calls.
        impl = null;

        // Tell the user.
        GWT.log("Unable to initialize the history subsystem; did you "
            + "include the history frame in your host page? Try "
            + "<iframe src=\"javascript:''\" id='__gwt_historyFrame' "
            + "style='position:absolute;width:0;height:0;border:0'>"
            + "</iframe>");
      }
    }

    public static String getToken() {
        // impl is null if you have not included the history frame in your host page
        // if impl is null then it return blank value
        return impl != null ? HistoryImpl.getToken() : "";
    }
}