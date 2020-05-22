public class MainActivity extends Activity {
    public enum ENUM {
        MISSION, FEATURED_MEDIA
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView = (TextView) findViewById(R.id.text);
        String enums = "";
        for (ENUM e : ENUM.values()) {
            enums += e + " ";
        }
        textView.setText(enums);
    }
}