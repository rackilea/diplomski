@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    ////////// Button object being created /////////////////
    this.mikesButton = (Button) findViewById(R.id.mikesButton); /// ref to the location by id
    this.mikesButton.setText("Click Me");
    this.mikesButton.setBackgroundColor(Color.RED);

    ///////// Input object called mikesText is added //////////////////////
    this.mikesText = (TextView) findViewById(R.id.mikesText);


    ///////// Set up an event listener for the button //////////////
    this.mikesButton.setOnClickListener(  /// listen for an event on this button
            new Button.OnClickListener() {   //// Interface
                public void onClick(View v) {    //// Callback method
                    MainActivity.this.mikesText.setText("Good job, it changed!");
                }
            }
    );


    ///////////// Listening for multiple events ////////////////////
    this.mikesButton.setOnLongClickListener(
            new Button.OnLongClickListener() {   //// Interface
                public boolean onLongClick(View v) {    //// Callback method
                    MainActivity.this.mikesText.setText("Good job, it changed when you held onto the button!");
                    return true;
                }
            }
    );


    //////////// Set up an event listener for a double tap event //////////////
    this.gestureDetector = new GestureDetectorCompat(this, this); /// an object from GD class to detect gestures
    this.gestureDetector.setOnDoubleTapListener(this); /// Set method to detect double taps


    //TODO: if you want to add a button from code
    Button otherButton = new Button(this);
    otherButton.setText("Hey i was made by code");
    otherButton.setBackgroundColor(Color.BLUE);

    ////////////// Rules of where to place the layout object ///////////////
    RelativeLayout.LayoutParams buttonDeets = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
    );

    //////////// Rules of where to place the button object ////////////////
    buttonDeets.addRule(RelativeLayout.CENTER_HORIZONTAL);
    buttonDeets.addRule(RelativeLayout.CENTER_VERTICAL);

    RelativeLayout mainLayout = this.findViewById(R.id.mainLayout); //<-- you have to set the id property of the RelativeLayout on the xml file
    mainLayout.addView(otherButton,buttonDeets);

}