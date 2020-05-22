//init the views.
et1.setVisiblity(GONE);
tv1.setVisiblity(VISIBLE);



 //if the textView is shown, the btn click will hide it and show editText 
 //instead, and same happens for editText
  btn1.setOnClickListener(new View.OnClickListener(){
  public void onClick(){

  if(et1.getVisiblity() != VISIBLE) {
        et1.setVisbility(VISIBLE);
        tv1.setVisibility(GONE);
   } else {
        et1.setVisbility(GONE);
        tv1.setVisibility(VISIBLE);
  }

  } });