public class TestDialog {

    private static final String TAG = TestDialog.class.getSimpleName();

    Activity mActivity;

    public TestDialog(Activity activity){
        mActivity = activity;
    }


    public void showDialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(mActivity);
        b.setTitle("Title");
        b.setMessage("message");
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e(TAG, "showDialog : onClick");
            }
        });
        b.create().show();
    }
}