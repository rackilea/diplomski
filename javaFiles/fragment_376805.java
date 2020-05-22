public class Scanner extends CordovaPlugin {
   ....
    private BroadcastReceiver mReceiver = null;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
       ....
       mReceiver = new BarcodeReceiver(callbackContext);
       ....
    }
   ....
}

public class BarcodeReceiver extends BroadcastReceiver {

    private CallbackContext callbackContext;

    public BarcodeReceiver (CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
    }

    public void onReceive(Context ctx, Intent intent) {
        if (intent.getAction().equals(ACTION_BARCODE_SERVICE_BROADCAST)) {
            strBarcode = intent.getExtras().getString(KEY_BARCODE_STR);
            callbackContext.success(strBarcode);
        }
    }
}