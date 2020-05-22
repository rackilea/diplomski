@Override
public void onBackPressed() {
    super.onBackPressed();
  Intent i=new Intent(this,MainActivity.class);
  i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
  i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  finish();
}