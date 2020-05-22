private void addView()
   {
       controlInflater = LayoutInflater.from(getBaseContext());
       View viewControl = controlInflater.inflate(R.layout.overlay, null);
       LayoutParams layoutParamsControl = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
       this.addContentView(viewControl, layoutParamsControl);

   }