int checked = -1;
RadioGroup rg = (RadioGroup) findViewById(R.id.rgType);
for(int i = 0; i < rg.getChildCount(); i++){
  if(((RadioButton)rg.getChildAt(i)).isChecked()){
     checked = i;
  }
}
editor.putInt("InfType", checked);