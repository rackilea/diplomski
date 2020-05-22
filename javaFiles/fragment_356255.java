public void onCreate(Bundle icicle){

       super.onCreate(icicle);
       setContentView(R.layout.main);

       ET = (EditText) findViewById(R.id.ET);
       btn = (Button) findViewById(R.id.btn);

       btn.setOnClickListener(this);
       updateTime();



}