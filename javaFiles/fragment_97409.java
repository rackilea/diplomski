@Override
//the function called when activity is created
public void onCreate(Bundle savedInstanceState) {
    //call the create fct. Of the base class
    super.onCreate(savedInstanceState);
    //load the layout specified in the layout.xml
    setContentView(R.layout.main);

    MainActivity m = new MainActivity();

    m.setDateText();
}