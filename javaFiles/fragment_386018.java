public boolean onOptionsItemSelected(MenuItem item) 
{
   Intent intent = new Intent();
   setResult(RESULT_OK, intent);
   finish();
   return super.onOptionsItemSelected(item); 
}