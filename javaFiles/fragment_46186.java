PreferenceScreen root = getPreferenceManager().createPreferenceScreen(this);
PreferenceCategory catView = new PreferenceCategory(this);
catView.setTitle(R.string.preference_category_view);
root.addPreference(catView);

final SwitchPreference switchSplash= new SwitchPreference(this);
switchSplash.setKey(PreferenceKeys.SPLASH); 

//-----the above code----
switchSplash.setChecked(false);       // LINE 1
catView.addPreference(switchSplash);  // LINE 2