public void updateValue(Preferences preferences,GregorianCalendar calendarG){

    preferences.putInteger(LAST_LOGIN_DAY,calendarG.get(Calendar.DAY_OF_YEAR));
    preferences.putInteger("dailyCombo", preferences.getInteger("dailyCombo",0) + 1);
    preferences.putInteger("Coin", preferences.getInteger("Coin",0) + preferences.getInteger("dailyCombo",0) * 25);

    preferences.flush();
}