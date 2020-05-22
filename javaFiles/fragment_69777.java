List <PreferenceScreen> prefScreens = new ArrayList<PreferenceScreen> ();
for (int i = 0; i < MainActivity.device_list.size(); i++) 
{
    prefScreens.add(new PreferenceScreen(getPreferenceManager().createPreferenceScreen(this)));
    prefScreens.get(i).setOnPreferenceClickListener(new DevicePreferenceListner());
}