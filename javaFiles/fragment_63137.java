Calendar now = Calendar.getInstance();
TextView output3 = (TextView) findViewById(R.id.output3);

int dayno = now.get(Calendar.DAY_OF_WEEK);
String dayName = new String();// also tried String dayName = ""; with the same results
if (dayno == 1) dayName = "Sun";
if (dayno == 2) dayName = "Mon";
if (dayno == 3) dayName = "Tue";
if (dayno == 4) dayName = "Wed";
if (dayno == 5) dayName = "Thu";
if (dayno == 6) dayName = "Fri";
if (dayno == 7) dayName = "Sat";