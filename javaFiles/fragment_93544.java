public class BaseActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if( // cache is not installed ) {
            // install the cache
        }
        getApplication().incrementInstanceCount();
    }

    public void onStop() {
        super.onStop();
        // flush the cache
    }

    public void onDestroy() {
        super.onDestroy();

        if( getApplication().decrementInstanceCount() == 0) {
            // close the cache
        }
    }
}