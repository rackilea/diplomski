SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(new Context());
boolean firstRun = prefs.getBoolean("IS_FIRST_RUN", true);
long now = System.currentTimeMillis();
if (firstRun)
{
    SharedPreferences.Editor editor = prefs.edit();
    editor.putBoolean("IS_FIRST_RUN", false);
    editor.putLong("FIRST_RUN_MILLIS", now);
    editor.apply();
}
else
{
    long dateFirstRun = prefs.getLong("FIRST_RUN_MILLIS", 0L);
    if (dateFirstRun == 0L)
    {
        // no value saved. decide how you want to handle
    }
    else if (now - dateFirstRun < SOME_AGE)
    {
        // offer extra functionality
    }
}