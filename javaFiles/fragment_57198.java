public class OneUpScreen extends ScreenFragment {   
    private Button name;
    private TextView c00Title, c00Data;

    //DEBUG
    public String title;

    //DEBUG
    private int counter = 0;

    //for logging and convenience
    private static final String TAG = "BRRT";   


    @Override
    public void onResume(){
        EventBus.getDefault().register(this);
        super.onResume();
    }

    @Override
    public void onDestroy(){
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    //process the bus messaging
    public void onEventMainThread(ExpeditionEvent event){      <-- READ IT FROM THE BUS
        Log.v(TAG, "OneUp event received: " + event.getEventId() + " : " + event.getEventScreenValue());
        c00Data.setText(""+counter);
        counter++;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.one_up_screen_layout, container, false);

        name = (Button) v.findViewById(R.id.lblTitle);
        c00Title = (TextView) v.findViewById(R.id.c00Title);
        c00Data = (TextView) v.findViewById(R.id.c00Data);

        Bundle bundle = this.getArguments();

        //initial set up of the text on the screen
        //null check
        name.setText((bundle.getString("name") == null) ? "error" : bundle.getString("name"));
        c00Title.setText((bundle.getString("c00Title") == null) ? "error" : bundle.getString("c00Title"));
        title = bundle.getString("c00Title");

        return v;
    }

    public OneUpScreen(){

    }

    public static OneUpScreen newInstance() {
        OneUpScreen frag = new OneUpScreen();
        return frag;
    }

    //attach the config for this instance.
    @Override
    public void setConfig(ScreenConfig sc){
        //set up the data to paint the screen for the first time
        Bundle b = new Bundle();

        //now we have to parse some stuff into a bundle and send the bundle to the fragment
        b.putString("name", sc.getName());
        b.putString("c00Title", sc.getEvents().get(0).getCleanName());
        b.putInt("c00Data", sc.getEvents().get(0).getEventID());

        //pass it along
        this.setArguments(b);
    }

}