RadioButton child[]=new RadioButton[5];
  for (int item = 1; item <= 5; item++) {
 child[i]= new RadioButton(this);
 itemRadioGroup.addView(child[i]);
 child[i].setId(item);
 Toast.makeText(getApplicationContext(),child.getID()+ " ", Toast.LENGTH_SHORT).show();
 }
//gets the checked radiobuttons ids

for (int item = 1; item <= 5; item++) {
if(child[i].isChecked()){

 Toast.makeText(getApplicationContext(),child[i].getID()+ " ", Toast.LENGTH_SHORT).show();

 }
}