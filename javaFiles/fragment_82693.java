RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);

group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) 
       {
        // TODO Auto-generated method stub
        if(radiobutton1.isChecked()) {
             fall.setVisibility(View.GONE);
             trip.setVisibility(View.GONE);
             illness.setVisibility(View.GONE);
        } else if(radiobutton2.isChecked()) {

        }
     }
});