public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {


private Context context;
private CallBackInterface callback;

// Constructor
public FingerprintHandler(Context mContext, CallBackInterface callback) {
    context = mContext;
    this.callback = callback;
}


public void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {
    CancellationSignal cancellationSignal = new CancellationSignal();
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
        return;
    }
    manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
}


@Override
public void onAuthenticationError(int errMsgId, CharSequence errString) {
    this.update("Fingerprint Authentication error\n" + errString, false);
}


@Override
public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
    this.update("Fingerprint Authentication help\n" + helpString, false);
}


@Override
public void onAuthenticationFailed() {
    this.update("Fingerprint Authentication failed.", false);
    Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    v.vibrate(1000);

    TextView lblFingerPrintError = (TextView) ((Activity)context).findViewById(R.id.lblFingerPrintError);
    lblFingerPrintError.setVisibility(View.VISIBLE);
    lblFingerPrintError.setText("Finger print did not match");
}


@Override
public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
    this.update("Fingerprint Authentication succeeded.", true);
    //here notify the caller about the success
    callback.onAuthenticationSucceed();

   // context.startActivity(new Intent(context, HomePage.class));
}


public void update(String e, Boolean success){
    if(success){
        Log.i("WW", "Matched");
    }
}