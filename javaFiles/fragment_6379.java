@Override 
      public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main); 
       // this should be first not in buttonclick2()
      textView2 = (TextView) findViewById(R.id.textView2);
       // then initialize views.  
      ...
      }