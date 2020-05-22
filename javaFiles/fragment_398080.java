int InfType = prefs.getInt("InfType", -1);
RadioGroup rg = (RadioGroup) findViewById(R.id.rgType);
if(InfType > -1) {
  ((RadioButton)rg.getChildAt(InfType)).toggle();
} else{
  ((RadioButton)rg.getChildAt(0)).toggle();
}