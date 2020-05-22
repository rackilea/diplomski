public void numero1(View view){ /*when i press a number, this method executes*/
Button button = (Button) view;
text += button.getText().toString();
if(text.substring(0,1).equals("."))
text="0"+text;    
display.setText(text);
}