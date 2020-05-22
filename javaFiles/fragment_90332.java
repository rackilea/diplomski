AppPreference appprefs;

public LegalProsecution(Context context)
{
    this.context = context;
    this.appprefs = new AppPreference("settings", context);
}