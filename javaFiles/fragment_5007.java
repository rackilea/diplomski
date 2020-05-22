private Preference.OnPreferenceClickListener getListener(int listenerId) {
    return new Preference.OnPreferenceClickListener() {
         @Override
         public boolean onPreferenceClick(Preference arg0) {
            Log.i("MyTag", "Listener " + listenerId + " invoked!");
            finish();   
            return true;
         }
    };
}