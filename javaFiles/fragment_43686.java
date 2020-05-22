private boolean sameDay(){

  boolean isSameDay = false;
 SharedPreferences pref = getApplicationContext().getSharedPreferences(YOUR_PREF_KEY, Context.MODE_PRIVAT);

 Calendar cal = Calendar.getInstance();
 SimpleDateFormat format =  new SimpleDateFormat("dd.MM.yyyy");
 Date today = cal.getTime();
 String day = format.format(today);

 String savedDate = pref.getString(YOUR_SAVED_DATE_KEY,"NONE");

 if(savedDate.equals(day){
    isSameDay=true;
 }else{
    isSameDay=false;
  } 
    return isSameDay;
}