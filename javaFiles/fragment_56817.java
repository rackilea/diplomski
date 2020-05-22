int storedMonth = prefs.getInt("myPreferenceKey", 0);
int currentMonth = LocalDate.now().getMonth().getValue();

if (storedMonth < currentMonth || (storedMonth == Month.DECEMBER.getValue() && currentMonth != Month.DECEMBER.getValue())) {

    SharedPreferences.Editor editor = prefs.edit();
    editor.putInt("myPreferenceKey", currentMonth);
    editor.apply();

}