public class LunarLander extends Activity {

    ....

    @Override
    protected void onPause() {
        mLunarView.getThread().pause(); // pause game when Activity pauses
        super.onPause();
    }
    ....
}