private void saveDay(){

  SharedPreferences pref = getApplicationContext().getSharedPreferences(YOUR_PREF_KEY, Context.MODE_PRIVAT);


 Editor editor = pref.edit();

 Calendar cal = Calendar.getInstance();
 SimpleDateFormat format =  new SimpleDateFormat("dd.MM.yyyy");
 Date today = cal.getTime();
 String day = format.format(today);

 editor.putString(YOUR_SAVED_DATE_KEY,day);
 editor.commit();
 }