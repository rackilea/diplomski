switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
      SharedPreferences settings = getSharedPreferences("preferences", 0);
      SharedPreferences.Editor editor = settings.edit();
      editor.putString("reminder", isChecked? "1" : "0") ;
      editor.commit();
}     
});