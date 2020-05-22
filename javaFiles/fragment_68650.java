public class MainActivity extends AppCompatActivity {

    private Handler handler;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //without the Looper.getMainLooper should work too
        handler = new Handler(Looper.getMainLooper());
        startProcessing();
    }

    private void startProcessing() {
        progressDialog = ProgressDialog.show(this, "Loading", "Loading data");
        t.start();
    }


    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                log("a new client connected");
            } catch (Exception e) {
                Log.e("TAG", e.getLocalizedMessage());
            }
        }
    });

    public void log(final String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}

xml can be as simple as:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!" />
</RelativeLayout>

//if the above code works for you then the problem is in some other place, but not the handler or UI thread.