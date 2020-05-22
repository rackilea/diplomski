public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);// I always want this in first line of onCreate
       showToast("Hello World!!");
    }

    public void showToast(String message){
       Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}