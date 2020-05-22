RadioGroup radioGroup = (RadioGroup) findViewById(R.id.bauRadioGroup);        
radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.bauRadio1){
            //radio button bauRadio1 was clicked
              baubau.setText("BAU");
            }
           else if(checkedId == R.id.bauRadio2 ){
             //radio button bauRadio2 was clicked
             baubau.setText("BAUUUUUUU");
           }
        }
    });
  //The rest of your code ...