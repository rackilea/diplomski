//Check for the key "tracker", if it does not exist consider the default value as 0
int appStartTracker = pref.getInt("tracker", 0);
if(appStartTracker == 0){
    // It means you started the app for the first time. Do what you have to
    // and set the preference to 1 or increment the appStartTracker to keep 
    //track of how many times the app has been started.
    appStartTracker++;
    editor.putInt("tracker", appStartTracker); 
    editor.commit(); 
}else{
    // Not a first time start.
    //Do the following if you need to keep track of total app starts else ignore
    appStartTracker++;
    editor.putInt("tracker", appStartTracker); 
    editor.commit(); 
    Log.d("TAG", "App has been started for the " + appStartTracker +"time");
}