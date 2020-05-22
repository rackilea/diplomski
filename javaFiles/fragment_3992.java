public class MusclesActivity extends AppCompatActivity {
Button btnRotate;
LinearLayout pic1,pic2;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
 setContentView(R.layout.activity_muscles); // place it here


 btnRotate = (Button)findViewById(R.id.btnRotate);
 pic1 = (LinearLayout)findViewById(R.id.frontpic);
 pic2 = (LinearLayout)findViewById(R.id.backpic);
}