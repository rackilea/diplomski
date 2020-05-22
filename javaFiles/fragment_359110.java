public class ListActivity extends Activity {

    ....

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacks(mRequestFocus);
        super.onDestroy();
    }
    ....    
}