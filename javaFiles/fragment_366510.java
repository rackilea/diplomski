@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.yourLayout);

    Bundle extra = getIntent().getExtras();
         if(extra!=null){
            test= extra.getString("WhatEvent_String");
      }
    addEvent(); // call your addEvent() method here
}