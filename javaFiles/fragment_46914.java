but.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
      LinearLayout parent = (LinearLayout) v.getParent(); // I assumed your MinutePicker extends LinearLayout
      LinearLayout L = (LinearLayout) parent.getParent();
      TextView Identifier = (TextView)L.findViewById(R.id.AMPMIdentifier);
      Identifier.setText("PM");
    }
});