private boolean contactExistInPhoneList(String number) {
    for (int i = 0; i < phoneListcontacts.size(); i++) {
        if (phoneListcontacts.get(i).getNumber().equalsIgnoreCase(number)) {
            Log.d(this.getClass().getSimpleName(), "Name= "+phoneListcontacts.get(i).getName());
            return true;
        }
    }
    return false;
}