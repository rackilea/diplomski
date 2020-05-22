... onCreate()
  {
  setContentView(...);
  ViewGroup myContainer=(ViewGroup)findViewById(R.id.myContainer);
  View v=inflateMySpecialView();
  //=<set layoutParams for the view if needed
  myContainer.addView(v);
  }

public View inflateMySpecialView()
  {
  ViewGroup viewgroup=(ViewGroup ) getLayoutInflater().inflate(R.layout.my_custom_layout, null,false);
  //do some stuff with the inflated viewgroup.
  return viewgroup;
  }