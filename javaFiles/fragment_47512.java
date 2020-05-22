public class TestActivity extends Activity {

public void onCreate(Bundle savedInstanceState) {   
    super.onCreate(savedInstanceState);    

    String icon = "image";        
    int resId = getResources().getIdentifier(icon, "drawable", getPackageName());

    ImageView imgView = new ImageView(this);
    imgView.setImageResource(resId);

    setContentView(imgView);
}