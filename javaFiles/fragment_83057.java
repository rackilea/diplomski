String entryIdentifierPrefix = "selectionState_listEntry_";

private void saveSelectedState(int entryPosition, boolean selectedState) {
    SharedPreferences.Editor spe = this.getSharedPreferences(
  spref_identifier, Context.MODE_PRIVATE).edit();
    spe.putBoolean(entryIdentifierPrefix + entryPosition, selectedState);
    spe.commit();
}

private boolean getSelectedState(int entryPosition) {
    SharedPreferences sp = this.getSharedPreferences(
  spref_identifier, Context.MODE_PRIVATE);
    return sp.getBoolean(entryIdentifierPrefix + entryPosition, false); // Default value is set as false. Tweak this if necessary.
}