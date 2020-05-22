@Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.open);

     //or whatever the id is for the image button in the open layout
     imageButton2 = (ImageButton) findViewById(R.id.imageButton2); 
     imageButton2.setOnClickListener(new View.OnClickListener() {