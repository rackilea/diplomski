@Override
public boolean onPreferenceChange(Preference preference, Object newValue) {

    if (preference.getKey().equals("switch_show_idle_dialog")) {

        //your code

        return true;
    } else if (preference.getKey().equals("currency_list")) {

        //your code

        return true;
    } else
        return false;
}