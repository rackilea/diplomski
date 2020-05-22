public static void load(){

    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(can);
    if (!prefs.getBoolean("firstTime", false)) {

        can.firstTime(); // This doesn't work like this

    }

}