public class MainActivity extends Activity {

    private ProgressDialog mLoadingDialog;
    private Handler mHandler = new Handler();
    private void showLoadingDialog(final String title, final String msg) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if(mLoadingDialog == null) {
                    mLoadingDialog = ProgressDialog.show(MainActivity.this, title, msg);
                }
                mLoadingDialog.setTitle(title);
                mLoadingDialog.setMessage(msg);
            }
        });
    }

private void hideLoadingDialog() {
    mHandler.post(new Runnable() { //Make sure it happens in sequence after showLoadingDialog
        @Override
        public void run() {
            if(mLoadingDialog != null) {
                mLoadingDialog.dismiss();
            }
        }
    });
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread() {
            @Override
            public void run() {
                showLoadingDialog("Loading", "Please wait...");
                //DO something
                hideLoadingDialog();
            }
        }.start();
    }
}