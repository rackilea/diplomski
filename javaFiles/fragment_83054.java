private enum Contact { CONTACT1 /*,... More enums */ }
String spref_identifier = "com.example.app";
String spref_contact1_selected = "contact1_selected";
...

private void saveSelectedState(Contact contact, Boolean selectedState) {
    SharedPreferences.Editor spe = this.getSharedPreferences(
  spref_identifier, Context.MODE_PRIVATE).edit();
    switch (contact) {
        case CONTACT1:
            spe.putBoolean(spref_contact1_selected, selectedState);
            spe.commit();
            break;
        [...]    // Other cases.
        default:
            break;
    }