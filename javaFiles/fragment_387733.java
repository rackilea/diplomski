public class ChangeContent extends Activity {

    TextView title1, title2;
    ImageView pic1, pic2;
    private static ArrayList<Integer> drawable;
    private static ArrayList<String> title;

public static ChangeContent(AnimalData data){
    drawable = new ArrayList<Integer>();
    title = new ArrayList<String>();
    drawable = data.getDrawable();
    title = data.getTitle();
}
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.animal_info);

    //findViewById for the TextView and ImageView
    //setText() for TextView and setImageResource() for ImageView
}
}