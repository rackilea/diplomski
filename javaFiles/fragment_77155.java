private EditText inputtxt;
private Button btnNext;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_g1);

    inputtxt = (EditText) findViewById(R.id.editText1);

    btnNext.setOnClickListener(new View.OnClickListener() 
        {

            @Override
            public void onClick(View ContentView) {
                // TODO Auto-generated method stub
                String name;

                  name=inputtxt.getText().toString();

                 if (name.equalsIgnoreCase("Accounting"))
                  {

                        Intent myIntent = new Intent (QuizActivity.this, NextActivity.class);
                        startActivity(myIntent);

                  }
                 else
                  {  Toast.makeText(getApplicationContext(), "Sorry, wrong answer. Try Again!", Toast.LENGTH_SHORT).show();
                  }     

        });
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.g1, menu);
        return true;        
    }