dmute.setOnClickListener(new View.OnClickListener() {
  public void onClick(View v) {
      if(!mutestatus){
        mutestatus = true;
        dmute.setBackgroundResource(R.drawable.soundoff);
      }
      else {
        mutestatus = false;
        dmute.setBackgroundResource(R.drawable.soundon);
      }
  }});