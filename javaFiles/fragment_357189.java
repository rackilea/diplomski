settingsPrefString = getSharedPreferences(SETTINGS_PREFERENCE , Context.MODE_PRIVATE);

if(settingsPrefString != null)
{
    weightSetting = settingsPrefString.getString("weightSetting", "Couldn't load data!");
} else {
    System.out.println("settingsPrefString is NULL!");
}