private static final int[] idArray = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5};

private Button[] bt = new Button[idArray.length];

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.start_layout);

    for (int i=0; i<idArray.length; i++) {
        final int b = i;
        bt [b] = (Button)findViewById(idArray[b]); // Fetch the view id from array
        bt [b].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

 Toast.makeText(getApplicationContext(),"This button will launch" + bt[b].getText().toString() + " App!!";,Toast.LENGTH_LONG).show();                }
        });

    }
}