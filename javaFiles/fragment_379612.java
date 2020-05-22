//step one
public class MySuperActivity extends Activity{
....
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            // step 2
        }
        return super.onKeyDown(keyCode, event);
    }
....
}
//step 3
public class MainActivity extends MySuperActivity{
    @override
    public void onCreate(Bundle b){
          // check for stuff as you want to from step 3
    }
}