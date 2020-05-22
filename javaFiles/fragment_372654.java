private SharedPreferences prefs;
    Editor editor = prefs.edit();

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);

    }