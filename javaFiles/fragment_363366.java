SharedPreferences settings = getSharedPreferences("prefs", 0);
    boolean firstRun = settings.getBoolean("firstRun", true);
    if ( firstRun )
    {
     //Open desclaimer
    }else{
//Do not open desclaimer
}