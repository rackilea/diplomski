public class TopImages extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        LinearLayout layoutContainer = (LinearLayout) this.findViewById(R.id.layout_container);
        TextView tv = new TextView(this);
        layoutContainer.addView(tv);

    }
}