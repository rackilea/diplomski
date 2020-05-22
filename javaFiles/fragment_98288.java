// You need a static String variable for identifying your preference 
public static final String CHOICE_PREF = "MyOptions";
SharedPreferences.Editor editor = getSharedPreferences(CHOICE_PREF, MODE_PRIVATE).edit();
editor.putBoolean("Clicked1_state", Clicked1); //("Id key", Value)
editor.putBoolean("Clicked2_state", Clicked2);
editor.putBoolean("Clicked3_state", Clicked3);
editor.putBoolean("Clicked4_state", Clicked4);
editor.apply();