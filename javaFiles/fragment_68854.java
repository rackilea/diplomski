btnDisplay.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View v)
{

  RadioButton selectedButton=   (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());  //you will get the selected radiobutton here

 String s=selectedButton..getText().toString();
 Toast.makeText(Radio_Button.this, "This is: " + s,Toast.LENGTH_LONG).show();

}