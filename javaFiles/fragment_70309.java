final Preference disableRemixingPref = (Preference) findPreference("disableRemixing");
    disableRemixingPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

        boolean toggle = false;
        public boolean onPreferenceClick(Preference preference) {
            disableRemixingPref.setSelectable(true);

            // Disable remixing by default
            ParseUser currentUser = ParseUser.getCurrentUser();
            currentUser.put("remixByDefault", toggle);
            currentUser.saveInBackground();

            toggle = !toggle;
            return toggle;
        }

    });