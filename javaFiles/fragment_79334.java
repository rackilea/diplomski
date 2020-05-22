@Override

public void onCreate(Bundle bundle) {
 Super.onCreate(bundle);
 setContentView(R.layout.main);
 LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
 LayoutInflater inflater = getLayoutInflater();
 if (condition) {
 inflater.inflate(R.layout.list_a, layout);
 inflater.inflate(R.layout.textview, layout);
 inflater.inflate(R.layout.list_b, layout);


} else { 
     inflater.inflate(R.layout.list_b, layout);
 inflater.inflate(R.layout.textview, layout);
 inflater.inflate(R.layout.list_a, layout);
 }
 }