public class mainActivity extends Activity {
    //make variable globally
    RelativeLayout myRelativeLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the layout file
        setContentView(R.layout.layout);

        //access the RelativeLayout and initialiszed the object
        myRelativeLayout = (RelativeLayout) findViewById(R.id.myRelativeLayout);
        myRelativeLayout.getChildCount();

    }
}