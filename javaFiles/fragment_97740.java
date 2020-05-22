protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.contactsettings_layout);
prefs = PreferenceManager.getDefaultSharedPreferences(this); //instantiate here
uiBinder();
btnManger();
}