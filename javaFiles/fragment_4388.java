private void displayDataCount(int dataCount) {
   if(dataCount > 0)
      Toast.makeText(getApplicationContext(), dataCount + " new news found", Toast.LENGTH_SHORT).show();
   else
      Toast.makeText(getApplicationContext(), "No new news found", Toast.LENGTH_SHORT).show();

}