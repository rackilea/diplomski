if( savedInstanceState!= null){ // get saved state from soft kill after first pass
    try {
        password= savedInstanceState.getString("password");
        Log.d(TAG,"RestoredState!");
    }
    catch(Exception e){
        Log.d(TAG,"FailedToRestoreState",e);
    }
}
else { // get saved state from preferences on first pass
    SharedPreferences prefs = getPreferences(MODE_PRIVATE); // singleton
    if (prefs != null){
        this.password= prefs.getString("password","");    
        Log.d(TAG,"gettingPrefs");
    }
}
Log.d(TAG,"onCreate");