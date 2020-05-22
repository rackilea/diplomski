class SettingsSpDao { // shared preferences data access object
    private static final String SP = "SP";
    private static final String MUSIC_YES = "music_yes";

    public static boolean isMusicYes(Context context) {
        // you can initialize sp beforehand so you don't have to pass in context but I prefer it this way, so I don't have to initialize it before using it 
        SharedPreferences sp = context.getSharedPreferences(SP, Context.MODE_PRIVATE); 
        return sp.getBoolean(MUSIC_YES , false);
    }

    // add your methods here
}

// call it anywhere as long as you can pass a context, such as Activity.
musicYes = SettingsSpDao.isMusicYes(this); // in your case `this` since it's in an Activity