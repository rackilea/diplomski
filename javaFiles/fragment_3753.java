public class MainActivity extends AppCompatActivity {
private LinearLayout linearLayout;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    linearLayout=findViewById(R.id.ll);
    int width=getScreenWidth(Main2Activity.this);

    int childCount=linearLayout.getChildCount();
    for (int i=0;i<childCount;i++){
        Button button= (Button) linearLayout.getChildAt(i);
        button.setWidth(width);
    }
}
public static int getScreenWidth(Context context) {
    WindowManager windowManager = (WindowManager) context
            .getSystemService(Context.WINDOW_SERVICE);
    DisplayMetrics dm = new DisplayMetrics();
    windowManager.getDefaultDisplay().getMetrics(dm);
    return dm.widthPixels;
} }