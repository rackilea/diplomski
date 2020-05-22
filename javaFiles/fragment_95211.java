public class Picture extends Activity{
@Override

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent=getIntent();
    int picture=intent.getIntExtra("picture", 22);
    setContentView(R.layout.tmp2);  
    ImageView image = (ImageView) findViewById(R.id.pansarvagn);
    image.setBackgroundResource(picture);

 }
}