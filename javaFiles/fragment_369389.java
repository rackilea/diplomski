Preference pLight = (Preference)findPreference("pref_light");
    Preference pSwitchSound = (Preference)findPreference("pref_switch_sound");
    Preference pNotificationSound = (Preference)findPreference("pref_notification_sound");

    pLight.setOnPreferenceClickListener(this);
    pSwitchSound.setOnPreferenceClickListener(this);
    pNotificationSound.setOnPreferenceClickListener(this);