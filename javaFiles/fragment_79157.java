const int COLLAPSED = 0;
const int EXPANDED = 1;
// set initial value(s) somewhere
holderFinal.setTag(COLLAPSED);
holderFinal.text.setText(shortText);


holderFinal.text.setOnClickListener( new View.OnClickListener() {       
@Override
  public void onClick(View v) {
    int i = (int)holderFinal.getTag();
    if (i == EXPANDED)
    {
      holderFinal.setTag(COLLAPSED);
      holderFinal.text.setText(shortText);
    }
    else
    {
      holderFinal.setTag(EXPANDED);
      holderFinal.text.setText(textData);
    }
  }
});