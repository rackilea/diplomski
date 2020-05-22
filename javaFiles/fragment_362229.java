public void setSetting(String key, String value) {

    if(getActivity() != null)
    {
        SharedPreferences settings = getActivity().getSharedPreferences("ProjectPref", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);

        // Commit the edits!
        editor.commit();
    }
}

public String getSetting(String key, String def) {

    try
    {
    SharedPreferences settings = getActivity().getSharedPreferences("ProjectPref", 0);
    return settings.getString(key, def);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

    return "";
}