private SharedPreferences prefs;
    Editor editor;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
       editor = prefs.edit();

    }