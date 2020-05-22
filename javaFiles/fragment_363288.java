SharedPreferences.Editor editor = mypref.edit();
//..
yourCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {   
       @Override
       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
           editor.putBoolean("playSounds", isChecked);
           editor.commit();
       }
   }
);