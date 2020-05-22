@Override
public void onClick(View v)
   {                        

try{
   int int1 = Integer.parseInt(number1.getText().toString().trim());//Edited line 
   int int2 = Integer.parseInt(number2.getText().toString().trim());//edited line 
   }catch(NumberFormatEception e){
     Toast.makeText(this,"try to enter a valid number", 3000).show();