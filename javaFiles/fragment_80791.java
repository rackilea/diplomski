BouttonRadio_R.setOnCheckedChangeListener(new
    CompoundButton.OnCheckedChangeListener() {
     @Override
     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
    {
       if (isChecked) {
            button.setEnabled(true);
        }
       else{
            button.setEnabled(false);
        }
}