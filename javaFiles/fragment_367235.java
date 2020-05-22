public class TheActivity extends FragmentActivity implements UtilssssCallback {

    public void urdu(View view) {
        // those two are not necessary but help make it obvious what parameters we have
        Context context = this;
        UtilssssCallback callback = this; // the class implements that
        new Utilssss(context, callback).execute("http://192.168.1.2/eWorldLiterature/urdu/index.txt");
    }

    @Override
    public void onResult(String string) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();
    }

....