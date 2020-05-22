radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);  
radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // find which radio button is selected
                        if(checkedId == R.id.rb1) {
                        // do action
                       }
           }
});
button.setOnClickListener(new OnClickListener() { 
         @Override          
         public void onClick(View v) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        // find which radioButton is checked by id
                        if(selectedId == R.id.rb1 ) { 
                          // you have chosen so and so radio button
                        } 
                         // similarly check other buttons
         } 
});