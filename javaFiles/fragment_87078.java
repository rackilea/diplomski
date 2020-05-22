Preferences preferences=Gdx.app.getPreferences("MyPref");
String LAST_LOGIN_DAY="lastloginday";    

GregorianCalendar calendarG = new GregorianCalendar();
calendarG.setTime(new Date());


if(!preferences.contains(LAST_LOGIN_DAY)) {
    //first day in App
    preferences.putInteger(LAST_LOGIN_DAY, calendarG.get(Calendar.DAY_OF_YEAR));
    preferences.flush();
}

if(preferences.getInteger(LAST_LOGIN_DAY)-1==calendarG.get(Calendar.DAY_OF_YEAR)){
    //next loginday up to a year

    updateValue(preferences,calendarG);

}else{

      if(calendarG.get(Calendar.DAY_OF_YEAR)==1) {

            // check for the 1st day of the year

            boolean isLeap = calendarG.isLeapYear(calendarG.get(Calendar.YEAR));
            if (isLeap && preferences.getInteger(LAST_LOGIN_DAY)==366 ) {

               updateValue(preferences,calendarG);

            }else  if(preferences.getInteger(LAST_LOGIN_DAY)==365){
                updateValue(preferences,calendarG);

            }
            else
                preferences.putInteger(LAST_LOGIN_DAY,calendarG.get(Calendar.DAY_OF_YEAR));
        }
        else
            preferences.putInteger(LAST_LOGIN_DAY,calendarG.get(Calendar.DAY_OF_YEAR));

}