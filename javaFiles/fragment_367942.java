@Override
public void onResume(){
    super.onResume();
    if (backFromChild){
         backFromChild = false;
         //do something with aString here
         Toast.makeText(this, aString, Toast.LENGTH_SHORT).show();
    }
}