private Doctor buildDoctor(String name, String surname, String address, String city, String preferredContact, String contactID, String specialism, String certificationDate) {
    if (specialism.equals("surgery")) {
        return new Surgeon(name, surname, address, city, preferredContact, contactID, specialism, certificationDate);
    } else {
        return new Doctor(name, surname, address, city, preferredContact, contactID, specialism);
    }
}