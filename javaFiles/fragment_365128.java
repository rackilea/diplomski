Context context;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
            this.context = this; 
    }


@Override
public void onReceivedError(WebView view, int errorCode,
            String description, String failingUrl) {
        AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(
                Webview_Main.this);
        localBuilder2.setTitle(R.string.webview_error_received_title);
        localBuilder2.setMessage(R.string.webview_error_received);
        localBuilder2.setIcon(R.drawable.ic_launcher);
        localBuilder2.setPositiveButton(R.string.alert_dialog_ok,
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramDialogInterface,int paramInt) {
                    if(haveInternet(context))
                        web.reload();
                    else
                        finish();
                }
            });
        localBuilder2.show();
    };

public boolean haveInternet(Context ctx) {

    NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx
            .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

    if (info == null || !info.isConnected()) {
        return false;
    }
    if (info.isRoaming()) {
        // here is the roaming option you can change it if you want to
        // disable internet while roaming, just return false
        return false;
    }
    return true;
}