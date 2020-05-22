public class MyDialogFragment extends DialogFragment {

    public MyDialogFragment newInstance() {
        MyDialogFragment fragment = new MyDialogFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.myBackgroundStyle);
        builder.setTitle("Exit Alert");
        builder.setMessage("Do you really want to exit the Game?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if (getActivity() instanceof DialogClickListener) {
                    ((DialogClickListener) getActivity()).onPositive();
                }
            }
        });
        return builder.create();
    }
}

public interface DialogClickListener {
    void onPositive();
}

public class MyActivity extends Activity implements DialogClickListener {

    private TextView textView; //rename this

    public void onCreate(...) {
        ...
        textView = (TextView) findViewById(R.id.textView123);
    }

    public void showExitDialog() {
         FragmentManager fm = getSupportFragmentManager();
         MyDialogFragment exitDlg = (MyDialogFragment) fm.findFragmetByTag(MyDialogFragment.TAG);
         if (exitDlg != null && exitDlg.isAdded()) {
             exitDlg.dismiss();
         }
         exitDlg = MyDialogFragment.newInstance();
         exitDlg.show(fm, AddEditDialogFragment.TAG);
    }

    public void onPositive() {
        final Handler handler = new Handler();
        final java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(3);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                if (n.getAndDecrement() >= 1 ) {
                    handler.postDelayed(this, 1000);
                } else {
                    GamePanel.thread.setRunning(true);
                }
                textView.setText(String.valueOf(n));
            }
         };
         handler.postDelayed(counter, 1000);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showExitDialog()
        }
    }

}