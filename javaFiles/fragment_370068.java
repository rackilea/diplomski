public static List<Phone> searchPhone(final String phoneNumber, final List<Phone> phoneList) {
    List<Phone> matchedPhone = new ArrayList<Phone>();

    for(Phone phone: phoneList) {
        if ( phone.getphoneNumber().equals(phoneNumber) ) { 
            matchedPhone.add(phone);
        }
    }

    return matchedPhone;
}