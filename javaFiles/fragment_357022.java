static void addListData(int TimeStamp, final String lat, final String lng,
        final String speed, final String direction, final Context context) {

    int todaystamp = startOf("today");
    int yesterdaystamp = startOf("yesterday");
    String Datetime = DateFormat.format("dd-MM-yyyy kk:mm:ss", new Date(TimeStamp * 1000L)).toString();

    String location = "*headline=" + lat + ", " + lng + ";speed=" + speed
            + ";direction=" + direction + ";date=" + Datetime + ";";

    SharedPreferences pref = context.getSharedPreferences("myPrefs",
            MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();

    if (TimeStamp >= todaystamp) {
        String today = pref.getString("Today",null);
        if (today != null) {
            StringBuilder str = new StringBuilder(today);
            str.insert(0, location + ", ");
            editor.putString("Today", str.toString());
        } else {
            editor.putString("Today", location);
        }
    } else if (TimeStamp >= yesterdaystamp) {
        String yesterday = pref.getString("Yesterday",null);
        if (yesterday != null) {
            StringBuilder str = new StringBuilder(yesterday);
            str.insert(0, location + ", ");
            editor.putString("Yesterday", str.toString());
        } else {
            editor.putString("Yesterday", location);
        }
    } else if (TimeStamp < yesterdaystamp) {
        String older = pref.getString("Older",null);
        if (older != null) {
            StringBuilder str = new StringBuilder(older);
            str.insert(0, location + ", ");
            editor.putString("Older", str.toString());
        } else {
            editor.putString("Older", location);
        }
    }

    editor.commit();
}