private Handler fileAccessThread = null;

public void onCreate() {
    super.onCreate();

    if (fileAccessThread == null) {
        fileAccessThread = new Handler();
        token = 0;
    }
}

public void postCallbackFileAccess (int _token, Runnable _callback) {
    switch (_token) {
    case TOKEN_SAVE:
        // Save must follow load, not another save
        if (token == TOKEN_SAVE) { return; }
        token = _token;
        break;

    case TOKEN_LOAD:
//      Have to allow load->load, otherwise data gets lost/deleted
//      if (token == TOKEN_LOAD) { return; }
        token = _token;
        break;
    }

    fileAccessThread.post (_callback);
}