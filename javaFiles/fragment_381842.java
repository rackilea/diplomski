@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    View rootView = inflater.inflate(R.layout.steps_layout,
            container, false);
    SetUpPedometer(rootView);
    return rootView;
}


public void SetUpPedometer(View view){

    // Attach objects to XML View
    textViewX=(TextView)view.findViewById(R.id.textViewX);
    textViewY=(TextView)view.findViewById(R.id.textViewY);
    textViewZ=(TextView)view.findViewById(R.id.textViewZ);

    //Attach Step and Sensitive View Objects to XML
    textViewSteps=(TextView)view.findViewById(R.id.textSteps);
    textSensitive=(TextView)view.findViewById(R.id.textSensitive);

    //Attach the resetButton to XML
    buttonReset = (Button)view.findViewById(R.id.buttonReset);

    //Attach the seekBar to XML
    seekBar = (SeekBar)view.findViewById(R.id.seekBar);

    //Set the Values on the seekBar, threshold, and threshold display
    seekBar.setProgress(10);
    seekBar.setOnSeekBarChangeListener(seekBarListener);
    threshold=10;
    textSensitive.setText(String.valueOf(threshold));

    // Initialize Values
    previousY = 0;
    currentY = 0;
    numSteps =0;

    buttonReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            numSteps = 0;
            textViewSteps.setText(String.valueOf(numSteps));
        }
    });

    // Initialize acceleration Values
    acceleration = 0.00f;

    // Enable the listener - We will write this later in the class
    enableAccelerometerListening();
}