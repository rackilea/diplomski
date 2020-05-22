private Boolean getSelectedState(Contact contact) {
    SharedPreferences sp = this.getSharedPreferences(
  spref_identifier, Context.MODE_PRIVATE);
    switch (contact) {
        case CONTACT1:
            return sp.getBoolean(spref_contact1_selected, false); // Default value is set as false. Tweak this if necessary.
        [...]    // Other cases.
        default:
            return false;
    }
}