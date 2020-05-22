class AnotherActivity extends AppCompatActivity {
    private final SaltStringPreference.Listener listener = new SaltStringPreference.Listener() {
        @Override
        protected void onSaltStringChanged(String saltString) {
            //Do something with new String...
        }
    }); 
    private SaltStringPreference pref;

    //onCreate...
    pref = SaltStringPreference.create(this);
    pref.setListener(listener);

    //onDestroy...
    pref.removeListener();
}